package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_map{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("webview1").vw.setTop((int)(0d));
views.get("webview1").vw.setLeft((int)(0d));
views.get("webview1").vw.setWidth((int)((56d / 100 * height)));
views.get("webview1").vw.setHeight((int)((170d / 100 * width)));

}
}