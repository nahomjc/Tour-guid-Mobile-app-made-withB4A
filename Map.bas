﻿B4A=true
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
	
	Dim cn As SQL
	Public cur As Cursor
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private WebView1 As WebView

End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("map")
	If File.Exists(File.DirInternal, "ahnr.db") = False Then
		File.Copy(File.DirAssets, "ahnr.db", File.DirInternal, "ahnr.db")
	End If
	cn.Initialize(File.DirInternal, "ahnr.db", False)
	show
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub show
	'WebView1.LoadUrl("https://ctrlq.org/maps/where/")
	WebView1.LoadUrl(data.lat)
End Sub
