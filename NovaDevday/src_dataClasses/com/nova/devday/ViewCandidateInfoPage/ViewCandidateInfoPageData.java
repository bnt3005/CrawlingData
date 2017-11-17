package com.nova.devday.ViewCandidateInfoPage;

/**
 */
@SuppressWarnings("all")
@javax.annotation.Generated(comments="This is the java file of the ivy data class ViewCandidateInfoPageData", value={"ch.ivyteam.ivy.scripting.streamInOut.IvyScriptJavaClassBuilder"})
public class ViewCandidateInfoPageData extends ch.ivyteam.ivy.scripting.objects.CompositeObject
{
  /** SerialVersionUID */
  private static final long serialVersionUID = 7758208333541489845L;

  private org.primefaces.model.StreamedContent excelFileStreamContent;

  /**
   * Gets the field excelFileStreamContent.
   * @return the value of the field excelFileStreamContent; may be null.
   */
  public org.primefaces.model.StreamedContent getExcelFileStreamContent()
  {
    return excelFileStreamContent;
  }

  /**
   * Sets the field excelFileStreamContent.
   * @param _excelFileStreamContent the new value of the field excelFileStreamContent.
   */
  public void setExcelFileStreamContent(org.primefaces.model.StreamedContent _excelFileStreamContent)
  {
    excelFileStreamContent = _excelFileStreamContent;
  }

  private java.util.List<com.nova.devday.CandidateInfo> candidateInfo;

  /**
   * Gets the field candidateInfo.
   * @return the value of the field candidateInfo; may be null.
   */
  public java.util.List<com.nova.devday.CandidateInfo> getCandidateInfo()
  {
    return candidateInfo;
  }

  /**
   * Sets the field candidateInfo.
   * @param _candidateInfo the new value of the field candidateInfo.
   */
  public void setCandidateInfo(java.util.List<com.nova.devday.CandidateInfo> _candidateInfo)
  {
    candidateInfo = _candidateInfo;
  }

}
