[Ivy]
[>Created: Thu Nov 16 16:38:45 ICT 2017]
15FC4092A20A66A9 3.18 #module
>Proto >Proto Collection #zClass
sl0 sendMail Big #zClass
sl0 B #cInfo
sl0 #process
sl0 @TextInP .resExport .resExport #zField
sl0 @TextInP .type .type #zField
sl0 @TextInP .processKind .processKind #zField
sl0 @AnnotationInP-0n ai ai #zField
sl0 @MessageFlowInP-0n messageIn messageIn #zField
sl0 @MessageFlowOutP-0n messageOut messageOut #zField
sl0 @TextInP .xml .xml #zField
sl0 @TextInP .responsibility .responsibility #zField
sl0 @StartSub f0 '' #zField
sl0 @EndSub f1 '' #zField
sl0 @EMail f3 '' #zField
sl0 @PushWFArc f4 '' #zField
sl0 @PushWFArc f2 '' #zField
>Proto sl0 sl0 sendMail #zField
sl0 f0 inParamDecl '<com.nova.devday.Email email> param;' #txt
sl0 f0 inParamTable 'out.email=param.email;
' #txt
sl0 f0 outParamDecl '<com.nova.devday.Email email> result;
' #txt
sl0 f0 outParamTable 'result.email=in.email;
' #txt
sl0 f0 actionDecl 'com.nova.devday.sendMailData out;
' #txt
sl0 f0 callSignature call(com.nova.devday.Email) #txt
sl0 f0 type com.nova.devday.sendMailData #txt
sl0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>call(Email)</name>
    </language>
</elementInfo>
' #txt
sl0 f0 81 49 30 30 -29 17 #rect
sl0 f0 @|StartSubIcon #fIcon
sl0 f1 type com.nova.devday.sendMailData #txt
sl0 f1 337 49 30 30 0 15 #rect
sl0 f1 @|EndSubIcon #fIcon
sl0 f3 beanConfig '"{/emailSubject ""<%=in.email.subject%>""/emailFrom ""<%=in.email.from%>""/emailReplyTo """"/emailTo ""<%=in.email.to%>""/emailCC """"/emailBCC """"/exceptionMissingEmailAttachments ""false""/emailMessage ""<%=in.email.content%>""/emailAttachments * }"' #txt
sl0 f3 type com.nova.devday.sendMailData #txt
sl0 f3 timeout 0 #txt
sl0 f3 168 42 112 44 0 -8 #rect
sl0 f3 @|EMailIcon #fIcon
sl0 f4 expr out #txt
sl0 f4 111 64 168 64 #arcP
sl0 f2 expr out #txt
sl0 f2 280 64 337 64 #arcP
>Proto sl0 .type com.nova.devday.sendMailData #txt
>Proto sl0 .processKind CALLABLE_SUB #txt
>Proto sl0 0 0 32 24 18 0 #rect
>Proto sl0 @|BIcon #fIcon
sl0 f0 mainOut f4 tail #connect
sl0 f4 head f3 mainIn #connect
sl0 f3 mainOut f2 tail #connect
sl0 f2 head f1 mainIn #connect
