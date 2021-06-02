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
	Dim cn As SQL
	Public cur As Cursor
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is cresated.
	'These variables can only be accessed from this module.

	Private Label1 As Label
	Private Label2 As Label
	Private Label4 As Label
	Private Buttonmap As Button
	Private ImageView1 As ImageView
	Private h As Hitex_RecyclerListView
	Private Hitex_ParallaxImageView1 As Hitex_ParallaxImageView
	Private ButtonHome As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("data_from_db")
	
	Activity.Color = 0xFFFAFAFA

	If File.Exists(File.DirInternal, "ahnr.db") = False Then
		File.Copy(File.DirAssets, "ahnr.db", File.DirInternal, "ahnr.db")
	End If

	cn.Initialize(File.DirInternal, "ahnr.db", False)

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
	loa
	
	h.Show(h.ANIMATION_ALPHAIN,1000,False)
	'Toolbar.FilterSearchForRecyclerListView(RLV)
	
	h.Divider.Add1(Colors.White,1dip)
   load
  
   image
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub loa

	Dim Cursor1 As Cursor
	'Dim name As String
	
	Try
		Cursor1 = cn.ExecQuery("SELECT * FROM '"&data.type&"'where name ='"&data.r&"'")
		For i = 0 To Cursor1.RowCount - 1
			Cursor1.Position = i
'			name = Cursor1.GetString("description")
'			h.AddTwoLines("About "&data.r,name)
			h.AddTwoLines2("About",Cursor1.GetString("description"),1)
			h.AddTwoLines2("Phone ", Cursor1.GetString("phone"),2)
			h.AddTwoLines2("Website ",Cursor1.GetString("site"),3)
			
		
		Next
	
	Catch		
		ToastMessageShow("Nothing found",False)
	End Try
	
	
End Sub



Sub h_ItemClick (Position As Int, Title As String, ReturnValue As Object)
	Dim s As Intent
	Select ReturnValue
		
		Case 2
			Dim Cursor As Cursor
			Cursor = cn.ExecQuery("SELECT phone FROM '"&data.type&"' where name='"& data.r &"' ")
			For i = 0 To Cursor.RowCount - 1
				Cursor.Position = i
				data.lat=Cursor.GetString("phone")
'				Msgbox("","fff")
			Next
			s.Initialize(s.ACTION_VIEW,"tel:+251911245434")
			StartActivity(s)
			
			
		Case 3
			Dim Cursor As Cursor
			Cursor = cn.ExecQuery("SELECT site FROM '"&data.type&"' where name='"& data.r &"' ")
			For i = 0 To Cursor.RowCount - 1
				Cursor.Position = i
				data.lat=Cursor.GetString("site")
		
			Next
	
			StartActivity(Map) 'webview 
		Case 4 
			Msgbox("","ddd")
		 
	End Select
			
End Sub



Sub load
	Dim Cursor As Cursor
	
	Cursor = cn.ExecQuery("SELECT name,phone,description,site FROM '"& data.Type &"' where name LIKE '%"&data.r&"%'")
	'%?% ",Array As String(data.r))

	For i = 0 To Cursor.RowCount - 1
		Cursor.Position = i	
	Next
End Sub


Sub Label1_Click
	
End Sub

Sub Label2_Click
	
End Sub

Sub Label3_Click
	
End Sub

Sub Label4_Click
	Dim Cursor As Cursor
	Cursor = cn.ExecQuery("SELECT site FROM '"&data.type&"' where name='"& data.r &"' ")
	For i = 0 To Cursor.RowCount - 1
		Cursor.Position = i
		data.lat=Cursor.GetString("site")
		
	Next
	
	StartActivity(Map)
End Sub



Sub Buttonmap_Click
	Dim Cursor As Cursor
	Cursor = cn.ExecQuery("SELECT map FROM '"&data.type&"' where name='"& data.r &"' ")
	For i = 0 To Cursor.RowCount - 1
		Cursor.Position = i
		data.lat=Cursor.GetString("map")
		
	Next
	
	StartActivity(Map) 'for webview map
End Sub

Sub Buttonback_Click
	StartActivity(type_list)
End Sub
Sub image
	Dim Cursor As Cursor	
	Dim buffer() As Byte
	Cursor = cn.ExecQuery("SELECT photo FROM '"&data.Type&"' where name='"&data.r&"'")
	For i = 0 To Cursor.RowCount - 1
		Cursor.Position = i
		buffer=Cursor.GetBlob("photo")
	Next
	
	Dim in As InputStream
	in.InitializeFromBytesArray(buffer, 0, buffer.Length)
	Dim bmp As Bitmap
	bmp.Initialize2(in)
	Hitex_ParallaxImageView1.ImageBitmap=bmp
	'ImageView1.Bitmap=bmp
	
	in.Close
End Sub

Sub Label1_LongClick
	
End Sub

Sub ButtonHome_Click
	StartActivity(Main)
End Sub