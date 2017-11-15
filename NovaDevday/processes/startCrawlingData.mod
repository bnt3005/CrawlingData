[Ivy]
[>Created: Wed Nov 15 16:38:35 ICT 2017]
15FBF01D998D2EFC 3.18 #module
>Proto >Proto Collection #zClass
sa0 startCrawlingData Big #zClass
sa0 B #cInfo
sa0 #process
sa0 @TextInP .resExport .resExport #zField
sa0 @TextInP .type .type #zField
sa0 @TextInP .processKind .processKind #zField
sa0 @AnnotationInP-0n ai ai #zField
sa0 @MessageFlowInP-0n messageIn messageIn #zField
sa0 @MessageFlowOutP-0n messageOut messageOut #zField
sa0 @TextInP .xml .xml #zField
sa0 @TextInP .responsibility .responsibility #zField
sa0 @StartRequest f0 '' #zField
sa0 @EndTask f1 '' #zField
sa0 @GridStep f3 '' #zField
sa0 @PushWFArc f4 '' #zField
sa0 @PushWFArc f2 '' #zField
>Proto sa0 sa0 startCrawlingData #zField
sa0 f0 outLink start.ivp #txt
sa0 f0 type com.nova.devday.Data #txt
sa0 f0 inParamDecl '<> param;' #txt
sa0 f0 actionDecl 'com.nova.devday.Data out;
' #txt
sa0 f0 guid 15FBF01D9DF5B35B #txt
sa0 f0 requestEnabled true #txt
sa0 f0 triggerEnabled false #txt
sa0 f0 callSignature start() #txt
sa0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
sa0 f0 @C|.responsibility Everybody #txt
sa0 f0 81 49 30 30 -21 17 #rect
sa0 f0 @|StartRequestIcon #fIcon
sa0 f1 type com.nova.devday.Data #txt
sa0 f1 449 49 30 30 0 15 #rect
sa0 f1 @|EndIcon #fIcon
sa0 f3 actionDecl 'com.nova.devday.Data out;
' #txt
sa0 f3 actionTable 'out=in;
' #txt
sa0 f3 actionCode 'import nova.devday.CrawlingService;
CrawlingService crawlingService = new CrawlingService();
crawlingService.crawlData();' #txt
sa0 f3 type com.nova.devday.Data #txt
sa0 f3 216 42 112 44 0 -8 #rect
sa0 f3 @|StepIcon #fIcon
sa0 f4 expr out #txt
sa0 f4 111 64 216 64 #arcP
sa0 f2 expr out #txt
sa0 f2 328 64 449 64 #arcP
>Proto sa0 .type com.nova.devday.Data #txt
>Proto sa0 .processKind NORMAL #txt
>Proto sa0 0 0 32 24 18 0 #rect
>Proto sa0 @|BIcon #fIcon
sa0 f0 mainOut f4 tail #connect
sa0 f4 head f3 mainIn #connect
sa0 f3 mainOut f2 tail #connect
sa0 f2 head f1 mainIn #connect
