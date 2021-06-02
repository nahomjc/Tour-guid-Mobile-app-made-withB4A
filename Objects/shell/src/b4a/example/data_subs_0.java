package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class data_subs_0 {


public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim r As String";
data._r = RemoteObject.createImmutable("");
 //BA.debugLineNum = 7;BA.debugLine="Dim lat,lon As String";
data._lat = RemoteObject.createImmutable("");
data._lon = RemoteObject.createImmutable("");
 //BA.debugLineNum = 8;BA.debugLine="Dim Type As String";
data._type = RemoteObject.createImmutable("");
 //BA.debugLineNum = 9;BA.debugLine="Dim im As Bitmap";
data._im = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Dim s As String";
data._s = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}