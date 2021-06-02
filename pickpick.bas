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
	Private h As Hitex_RecyclerListView
	
	Private Hitex_ParallaxImageView1 As Hitex_ParallaxImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("help")
	
	h.Initializer("h").Header.Build
	h.HeaderPanel.LoadLayout("header")
	h.Height=47%y
	h.HeaderPanel.Color=Colors.Blue
	Hitex_ParallaxImageView1.Width=100%x
	Hitex_ParallaxImageView1.Top=0
	Hitex_ParallaxImageView1.Left=0
	Hitex_ParallaxImageView1.Height=h.Height
	Hitex_ParallaxImageView1.SetParallaxStyles(Hitex_ParallaxImageView1.Style_VerticalAlpha)
	Activity.AddView(h,0,56dip,-1,100%y-56dip)
	
	h.Gravity = Gravity.LEFT	
	h.Show(h.ANIMATION_ALPHAIN,1000,False)
	
	
	h.Divider.Add1(Colors.White,1dip)

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
