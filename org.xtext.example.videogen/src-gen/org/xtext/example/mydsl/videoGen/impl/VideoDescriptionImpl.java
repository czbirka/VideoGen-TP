/**
 * generated by Xtext 2.12.0
 */
package org.xtext.example.mydsl.videoGen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.example.mydsl.videoGen.Filter;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGenPackage;
import org.xtext.example.mydsl.videoGen.VideoText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Video Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getVideoid <em>Videoid</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VideoDescriptionImpl extends MediaDescriptionImpl implements VideoDescription
{
  /**
   * The default value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideoid()
   * @generated
   * @ordered
   */
  protected static final String VIDEOID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideoid()
   * @generated
   * @ordered
   */
  protected String videoid = VIDEOID_EDEFAULT;

  /**
   * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected static final int DURATION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected int duration = DURATION_EDEFAULT;

  /**
   * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProbability()
   * @generated
   * @ordered
   */
  protected static final int PROBABILITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProbability()
   * @generated
   * @ordered
   */
  protected int probability = PROBABILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getFilter() <em>Filter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilter()
   * @generated
   * @ordered
   */
  protected Filter filter;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected VideoText text;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VideoDescriptionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VideoGenPackage.Literals.VIDEO_DESCRIPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVideoid()
  {
    return videoid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVideoid(String newVideoid)
  {
    String oldVideoid = videoid;
    videoid = newVideoid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID, oldVideoid, videoid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDuration()
  {
    return duration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuration(int newDuration)
  {
    int oldDuration = duration;
    duration = newDuration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__DURATION, oldDuration, duration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getProbability()
  {
    return probability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProbability(int newProbability)
  {
    int oldProbability = probability;
    probability = newProbability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY, oldProbability, probability));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Filter getFilter()
  {
    return filter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFilter(Filter newFilter, NotificationChain msgs)
  {
    Filter oldFilter = filter;
    filter = newFilter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__FILTER, oldFilter, newFilter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFilter(Filter newFilter)
  {
    if (newFilter != filter)
    {
      NotificationChain msgs = null;
      if (filter != null)
        msgs = ((InternalEObject)filter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_DESCRIPTION__FILTER, null, msgs);
      if (newFilter != null)
        msgs = ((InternalEObject)newFilter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_DESCRIPTION__FILTER, null, msgs);
      msgs = basicSetFilter(newFilter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__FILTER, newFilter, newFilter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VideoText getText()
  {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetText(VideoText newText, NotificationChain msgs)
  {
    VideoText oldText = text;
    text = newText;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__TEXT, oldText, newText);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setText(VideoText newText)
  {
    if (newText != text)
    {
      NotificationChain msgs = null;
      if (text != null)
        msgs = ((InternalEObject)text).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_DESCRIPTION__TEXT, null, msgs);
      if (newText != null)
        msgs = ((InternalEObject)newText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_DESCRIPTION__TEXT, null, msgs);
      msgs = basicSetText(newText, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__TEXT, newText, newText));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__FILTER:
        return basicSetFilter(null, msgs);
      case VideoGenPackage.VIDEO_DESCRIPTION__TEXT:
        return basicSetText(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        return getVideoid();
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        return getDuration();
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        return getProbability();
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        return getDescription();
      case VideoGenPackage.VIDEO_DESCRIPTION__FILTER:
        return getFilter();
      case VideoGenPackage.VIDEO_DESCRIPTION__TEXT:
        return getText();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        setVideoid((String)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        setDuration((Integer)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        setProbability((Integer)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__FILTER:
        setFilter((Filter)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__TEXT:
        setText((VideoText)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        setVideoid(VIDEOID_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        setDuration(DURATION_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        setProbability(PROBABILITY_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__FILTER:
        setFilter((Filter)null);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__TEXT:
        setText((VideoText)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        return VIDEOID_EDEFAULT == null ? videoid != null : !VIDEOID_EDEFAULT.equals(videoid);
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        return duration != DURATION_EDEFAULT;
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        return probability != PROBABILITY_EDEFAULT;
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case VideoGenPackage.VIDEO_DESCRIPTION__FILTER:
        return filter != null;
      case VideoGenPackage.VIDEO_DESCRIPTION__TEXT:
        return text != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (videoid: ");
    result.append(videoid);
    result.append(", duration: ");
    result.append(duration);
    result.append(", probability: ");
    result.append(probability);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //VideoDescriptionImpl