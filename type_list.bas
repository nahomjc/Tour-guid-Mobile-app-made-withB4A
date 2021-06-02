B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
    #Extends: android.support.v7.app.AppCompatActivity
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
	Private RLV As Hitex_RecyclerListView
	Private Toolbar As Hitex_SearchToolbar
   

End Sub

Sub Activity_Create(FirstTime As Boolean)

	Activity.Color = 0xFFFAFADF
  
	If File.Exists(File.DirInternal, "ahnr.db") = False Then
		File.Copy(File.DirAssets, "ahnr.db", File.DirInternal, "ahnr.db")
		
	End If

	cn.Initialize(File.DirInternal, "ahnr.db", False)
	
	Toolbar.Initialize("Toolbar")
	Activity.AddView(Toolbar,0,0,-1,56dip)
	Toolbar.Title = data.Type.ToUpperCase & " LIST"
	Toolbar.Elevation=4dip
	Toolbar.SearachView_QueryHint="Search by name..."
  

	RLV.Initializer("RLV").Build
	Activity.AddView(RLV,0,56dip,-1,100%y-56dip)
	
	RLV.Gravity = Gravity.LEFT
	load
			RLV.Show(RLV.ANIMATION_ALPHAIN,1000,False)
			Toolbar.FilterSearchForRecyclerListView(RLV)	
	RLV.Divider.Add1(Colors.White,1dip)
	
End Sub

Sub RLV_ItemClick (Position As Int, Title As String, ReturnValue As Object)
	data.r = Title
	StartActivity(data_from_db)
End Sub

Sub RLV_GetFastscrollSectionTitle (Position As Int) As String
	Return Position
End Sub


Sub load

	Dim Cursor1 As Cursor
	Dim name As String
'	
	Try
		Cursor1 = cn.ExecQuery("SELECT name FROM '"&data.type&"'")
		For i = 0 To Cursor1.RowCount - 1
			Cursor1.Position = i
			name = Cursor1.GetString("name")
			RLV.AddTwoLines(name,"")
		Next
	
	Catch
		ToastMessageShow("Nothing found",False)
	End Try
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


