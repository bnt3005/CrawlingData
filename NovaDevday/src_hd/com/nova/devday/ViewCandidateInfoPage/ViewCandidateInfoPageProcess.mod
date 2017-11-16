[Ivy]
[>Created: Thu Nov 16 13:44:02 ICT 2017]
15FC28DA79159D3C 3.18 #module
>Proto >Proto Collection #zClass
Vs0 ViewCandidateInfoPageProcess Big #zClass
Vs0 RD #cInfo
Vs0 #process
Vs0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
Vs0 @TextInP .rdData2UIAction .rdData2UIAction #zField
Vs0 @TextInP .resExport .resExport #zField
Vs0 @TextInP .type .type #zField
Vs0 @TextInP .processKind .processKind #zField
Vs0 @AnnotationInP-0n ai ai #zField
Vs0 @MessageFlowInP-0n messageIn messageIn #zField
Vs0 @MessageFlowOutP-0n messageOut messageOut #zField
Vs0 @TextInP .xml .xml #zField
Vs0 @TextInP .responsibility .responsibility #zField
Vs0 @RichDialogInitStart f0 '' #zField
Vs0 @RichDialogProcessEnd f1 '' #zField
Vs0 @RichDialogProcessStart f3 '' #zField
Vs0 @RichDialogEnd f4 '' #zField
Vs0 @PushWFArc f5 '' #zField
Vs0 @GridStep f6 '' #zField
Vs0 @PushWFArc f7 '' #zField
Vs0 @PushWFArc f2 '' #zField
>Proto Vs0 Vs0 ViewCandidateInfoPageProcess #zField
Vs0 f0 guid 15FC28DA7C1D3E88 #txt
Vs0 f0 type com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData #txt
Vs0 f0 method start() #txt
Vs0 f0 disableUIEvents true #txt
Vs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
Vs0 f0 outParameterDecl '<> result;
' #txt
Vs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Vs0 f0 83 51 26 26 -16 15 #rect
Vs0 f0 @|RichDialogInitStartIcon #fIcon
Vs0 f1 type com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData #txt
Vs0 f1 339 51 26 26 0 12 #rect
Vs0 f1 @|RichDialogProcessEndIcon #fIcon
Vs0 f3 guid 15FC28DA7EFF0378 #txt
Vs0 f3 type com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData #txt
Vs0 f3 actionDecl 'com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData out;
' #txt
Vs0 f3 actionTable 'out=in;
' #txt
Vs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Vs0 f3 83 147 26 26 -15 12 #rect
Vs0 f3 @|RichDialogProcessStartIcon #fIcon
Vs0 f4 type com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData #txt
Vs0 f4 guid 15FC28DA7EF9307E #txt
Vs0 f4 211 147 26 26 0 12 #rect
Vs0 f4 @|RichDialogEndIcon #fIcon
Vs0 f5 expr out #txt
Vs0 f5 109 160 211 160 #arcP
Vs0 f6 actionDecl 'com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData out;
' #txt
Vs0 f6 actionTable 'out=in;
' #txt
Vs0 f6 actionCode 'import nova.devday.persistent.CrawlingPersistentService;
import java.util.ArrayList;
import com.nova.devday.CandidateInfo;

CrawlingPersistentService crawlingPersistentService = new CrawlingPersistentService();
in.candidateInfos = crawlingPersistentService.getCandidateInfoList();
' #txt
Vs0 f6 type com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData #txt
Vs0 f6 168 42 112 44 0 -8 #rect
Vs0 f6 @|StepIcon #fIcon
Vs0 f7 expr out #txt
Vs0 f7 109 64 168 64 #arcP
Vs0 f2 expr out #txt
Vs0 f2 280 64 339 64 #arcP
>Proto Vs0 .type com.nova.devday.ViewCandidateInfoPage.ViewCandidateInfoPageData #txt
>Proto Vs0 .processKind HTML_DIALOG #txt
>Proto Vs0 -8 -8 16 16 16 26 #rect
>Proto Vs0 '' #fIcon
Vs0 f3 mainOut f5 tail #connect
Vs0 f5 head f4 mainIn #connect
Vs0 f0 mainOut f7 tail #connect
Vs0 f7 head f6 mainIn #connect
Vs0 f6 mainOut f2 tail #connect
Vs0 f2 head f1 mainIn #connect
