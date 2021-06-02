B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	'Dim SD As SlidingPanels
	Private WebView1 As WebView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
     Activity.LoadLayout("QR")
	WebView1.LoadUrl("https://www.google.com/maps/place/Megenagna/@9.0204692,38.8002142,17z/data=!3m1!4b1!4m5!3m4!1s0x164b855cd643a691:0x5ce3922436b4f99a!8m2!3d9.0204692!4d38.8024029")
	'WebView1.LoadUrl("https://www.google.com/maps/@9.0013696,38.7653632,13z")
'	If File.Exists(File.DirInternal, "ahnr.db") = False Then
'		File.Copy(File.DirAssets, "ahnr.db", File.DirInternal, "ahnr.db")
'	End If
'	call

End Sub
Sub Activity_Resume

End Sub
'Sub call
''     Dim s As Intent
''	 s.Initialize(s.ACTION_VIEW,"tel:")
''	 StartActivity(data.r)
''	'StartActivity(s)
'End Sub
Sub Activity_Pause (UserClosed As Boolean)

End Sub
