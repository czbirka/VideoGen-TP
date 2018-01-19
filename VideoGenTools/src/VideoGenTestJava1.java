import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.AlternativesMedia;
import org.xtext.example.mydsl.videoGen.MandatoryMedia;
import org.xtext.example.mydsl.videoGen.Media;
import org.xtext.example.mydsl.videoGen.MediaDescription;
import org.xtext.example.mydsl.videoGen.OptionalMedia;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

public class VideoGenTestJava1 {

	private static final String INPUT_VIDEOGEN = "example2.videogen";
	private static final String FFMPEG_DURATION_COMMAND = "ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 ";
	private static final String FFMPEG_CONCAT_PREFIX_FILE = "file ";
	private static final String VLC_BASE_COMMAND = "vlc --play-and-exit ";
	private static final String OUTPUT = "ff.txt";
	private static final String COMPILATION_NAME = "compilation.mp4";

	private Process runCommandInterpretedMode(String command) {
		Process p = null;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();

		} catch (IOException e) {
			System.err.println("Echec au lancement de la commande : " + command);
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return p;
	}

	private int nbVariante(VideoGeneratorModel videogen) {
		EList<Media> medias = videogen.getMedias();

		int variantes = 1;

		for (Media media : medias) {
			if (media instanceof MandatoryMedia) {
				// NOTHING TO DO HERE
			} else if (media instanceof OptionalMedia) {
				variantes *= 2;
			} else if (media instanceof AlternativesMedia) {
				variantes *= ((AlternativesMedia) media).getMedias().size();
			}
		}

		return variantes;
	}

	@Test
	public void testNbVariante() {
		int max = 7;
		for (int i = 1; i <= max; i++) {
			VideoGeneratorModel videoGen = new VideoGenHelper()
					.loadVideoGenerator(URI.createURI("example" + i + ".videogen"));
			assertNotNull(videoGen);
			System.out.println("example" + i + "::nbVariantes = " + nbVariante(videoGen));
		}
	}

	@Test
	public void testNbVarianteCSV() {

		// VIDEOGEN
		String example = "example2.videogen";

		// CSV
		String csvName = "CSV-videogen-sample - Sheet1.csv"; // CSV for example2
		Path csvPath = new File(csvName).toPath();

		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI(example));
		assertNotNull(videoGen);

		try (Stream<String> lines = Files.lines(csvPath, Charset.defaultCharset())) {
			long numOfLines = lines.count();
			assertEquals("It should be equal", numOfLines, nbVariante(videoGen) + 1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}

	@Test
	public void testInterpretedModeWithVLC() throws InterruptedException, IOException {

		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI(INPUT_VIDEOGEN));
		assertNotNull(videoGen);
		nbVariante(videoGen);

		List<String> playlist = new ArrayList<>();
		EList<Media> medias = videoGen.getMedias();

		String videoLocation;

		// Mode interprété
		for (Media media : medias) {
			if (media instanceof MandatoryMedia) {
				MediaDescription description = ((MandatoryMedia) media).getDescription();

				if (description instanceof VideoDescription) {
					videoLocation = description.getLocation();

					// Tape ta commande
					String command = VLC_BASE_COMMAND + videoLocation;
					runCommandInterpretedMode(command);
				}

			} else if (media instanceof OptionalMedia) {
				MediaDescription description = ((OptionalMedia) media).getDescription();

				Random rand = new Random();
				int decision = rand.nextInt(2); // 0 ou 1

				// decision = 1 on prend sinon O donc on laisse
				if (decision == 1) {
					// On prend cette video
					if (description instanceof VideoDescription) {
						videoLocation = description.getLocation();

						// Tape ta commande
						String command = VLC_BASE_COMMAND + videoLocation;
						runCommandInterpretedMode(command);
					}
				}
			} else if (media instanceof AlternativesMedia) {
				// On récupère toutes les possibilités des videos alternatives
				EList<MediaDescription> alternatives = ((AlternativesMedia) media).getMedias();

				// On sélectionne la vidéo qui sera jouée
				Random rand = new Random();
				int selectedVideo = rand.nextInt(alternatives.size()); // index de la video = [0, medias.size[
				MediaDescription selectedMedia = alternatives.get(selectedVideo);

				// On récupère les informations de la video et on applique les traitements
				if (selectedMedia instanceof VideoDescription) {
					videoLocation = selectedMedia.getLocation();

					// Tape ta commande
					String command = VLC_BASE_COMMAND + videoLocation;
					runCommandInterpretedMode(command);
				}
			}
		}
	}

	@Test
	public void testCompiledModeWithFFMPEG() throws InterruptedException, IOException {

		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI(INPUT_VIDEOGEN));
		assertNotNull(videoGen);
		nbVariante(videoGen);

		List<String> playlist = new ArrayList<>();
		EList<Media> medias = videoGen.getMedias();

		String videoLocation;

		int totalSize = 0; // Taille totale de la variante

		// Mode interprété
		for (Media media : medias) {
			if (media instanceof MandatoryMedia) {
				MediaDescription description = ((MandatoryMedia) media).getDescription();

				if (description instanceof VideoDescription) {
					videoLocation = description.getLocation();

					// On ajoute la video à notre playlist
					playlist.add(FFMPEG_CONCAT_PREFIX_FILE + videoLocation);
				}

			} else if (media instanceof OptionalMedia) {
				MediaDescription description = ((OptionalMedia) media).getDescription();

				Random rand = new Random();
				int decision = rand.nextInt(2); // 0 ou 1

				// decision = 1 on prend sinon O donc on laisse
				if (decision == 1) {
					// On prend cette video
					if (description instanceof VideoDescription) {
						videoLocation = description.getLocation();

						// On ajoute la video à notre playlist
						playlist.add(FFMPEG_CONCAT_PREFIX_FILE + videoLocation);
					}
				}
			} else if (media instanceof AlternativesMedia) {
				// On récupère toutes les possibilités des videos alternatives
				EList<MediaDescription> alternatives = ((AlternativesMedia) media).getMedias();

				// On sélectionne la vidéo qui sera jouée
				Random rand = new Random();
				int selectedVideo = rand.nextInt(alternatives.size()); // index de la video = [0, medias.size[
				MediaDescription selectedMedia = alternatives.get(selectedVideo);

				// On récupère les informations de la video et on applique les traitements
				if (selectedMedia instanceof VideoDescription) {
					videoLocation = selectedMedia.getLocation();

					// On ajoute la video à notre playlist
					playlist.add(FFMPEG_CONCAT_PREFIX_FILE + videoLocation);
				}
			}
		}

		Path out = Paths.get(OUTPUT);
		Files.write(out, playlist, Charset.defaultCharset());

		String ffmpeg = "ffmpeg -f concat -safe 0 -i " + OUTPUT + " -c -y copy " + COMPILATION_NAME;

//		String ffmpeg = "ffmpeg -f concat -i " + OUTPUT + " -preset ultrafast -c -y copy " + COMPILATION_NAME;
		runCommandInterpretedMode(ffmpeg);
		runCommandInterpretedMode(VLC_BASE_COMMAND + COMPILATION_NAME);

		System.out.println("La taille totale de la sélection est : " + totalSize);
	}

	@Test
	public void testVarianteDePlusLongueDuree() throws InterruptedException, IOException {

		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI(INPUT_VIDEOGEN));
		assertNotNull(videoGen);
		nbVariante(videoGen);

		EList<Media> medias = videoGen.getMedias();

		double videoDuration = 0.0;
		String videoLocation;

		// Mode interprété
		for (Media media : medias) {
			if (media instanceof MandatoryMedia) {
				MediaDescription description = ((MandatoryMedia) media).getDescription();

				if (description instanceof VideoDescription) {
					videoLocation = description.getLocation();

					// On execute la commande FFMPEG et on recupère la durée
					String command = FFMPEG_DURATION_COMMAND + videoLocation;
					Process p = runCommandInterpretedMode(command);
					double test = getVideoDescriptionDurationWithFFMPEG(p);
					System.out.println("[Mandatory] " + videoLocation + " duration ffmpeg=" + test);
					videoDuration += test;
				}

			} else if (media instanceof OptionalMedia) {
				MediaDescription description = ((OptionalMedia) media).getDescription();

				// On prend systématiquement la video
				if (description instanceof VideoDescription) {
					videoLocation = description.getLocation();

					// On execute la commande FFMPEG et on recupère la durée
					String command = FFMPEG_DURATION_COMMAND + videoLocation;
					Process p = runCommandInterpretedMode(command);
					double test = getVideoDescriptionDurationWithFFMPEG(p);
					System.out.println("[Optional] " + videoLocation + " duration ffmpeg=" + test);
					videoDuration += test;
				}
			} else if (media instanceof AlternativesMedia) {
				// On récupère toutes les possibilités des videos alternatives
				EList<MediaDescription> alternatives = ((AlternativesMedia) media).getMedias();
				MediaDescription mostLongAlternative = null;

				double max = 0.0;
				for (MediaDescription possibility : alternatives) {

					if (possibility instanceof VideoDescription) {
						videoLocation = possibility.getLocation();

						// On execute la commande FFMPEG et on recupère la durée
						String command = FFMPEG_DURATION_COMMAND + videoLocation;
						Process p = runCommandInterpretedMode(command);

						// On considère cette vidéo
						double test = getVideoDescriptionDurationWithFFMPEG(p);
						if (max < test) {
							mostLongAlternative = possibility;
							max = test;
						}
						System.out.println("[alternative] " + videoLocation + " duration ffmpeg=" + test);
					}
				}

				// On récupère les informations de la video et on applique les traitements
				if (mostLongAlternative != null && mostLongAlternative instanceof VideoDescription) {
					videoLocation = mostLongAlternative.getLocation();

					// String command = FFMPEG_DURATION_COMMAND + videoLocation;
					// Process p = runCommandInterpretedMode(command);
					// System.out.println("[alternative] selected " + videoLocation + " duration :
					// max=" + max + " ffmpeg="
					// + getVideoDescriptionDurationWithFFMPEG(p));
					videoDuration += max;
				}
			}
		}
		System.out.println("Videogen Most Long Variante: " + videoDuration);
	}

	private double getVideoDescriptionDurationWithFFMPEG(Process p) throws IOException {
		double videoDuration = 0;
		if (p != null) {
			BufferedReader output = getOutput(p);

			String ligne = "";
			ligne = output.readLine();
			if (ligne != null) {
				videoDuration += Double.parseDouble(ligne);
			}
		}
		return videoDuration;
	}

	private boolean checkIfVideoHasSound(Process p) throws IOException {
		boolean noSound = false;
		if (p != null) {
			BufferedReader output = getOutput(p);

			String ligne = "";
			ligne = output.readLine();

			// vrai si la ligne n'est pas vide - présence de son
			return ligne != null && !"".equals(ligne);
		}
		return noSound;
	}

	private void addNullSoundToVideo(boolean noSound) {
		if (noSound) {
			// Pas de son, on ajoute

			// Execution de la commande complexe et création de la vidéo

			// On ajoute cette nouvelle vidéo à la playlist au lieu de la vidéo initiale

			// On execute la commande FFMPEG pour la concaténation
		}
	}

	private BufferedReader getOutput(Process p) {
		BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
		return output;
	}
}
