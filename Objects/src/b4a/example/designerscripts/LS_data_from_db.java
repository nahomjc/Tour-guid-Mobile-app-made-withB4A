package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_data_from_db{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
String _buttonmapleft="";
views.get("imageview1").vw.setLeft((int)(2d));
views.get("label1").vw.setLeft((int)(350d));
views.get("label2").vw.setLeft((int)(350d));
views.get("label2").vw.setTop((int)(140d));
views.get("buttonhome").vw.setTop((int)(0-2d));
views.get("buttonhome").vw.setLeft((int)((72d / 100 * width)));
views.get("buttonhome").vw.setHeight((int)(100d));
views.get("buttonmap").vw.setWidth((int)((65d * scale)));
views.get("buttonmap").vw.setHeight((int)((65d * scale)));
views.get("buttonmap").vw.setTop((int)((84d / 100 * height)));
_buttonmapleft = BA.NumberToString((92d / 100 * width));

}
}