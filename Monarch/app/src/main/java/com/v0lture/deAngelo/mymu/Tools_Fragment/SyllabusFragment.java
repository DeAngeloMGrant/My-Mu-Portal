package com.v0lture.deAngelo.mymu.Tools_Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.v0lture.deAngelo.mymu.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class SyllabusFragment extends Fragment {

    static String str_Camera_Photo_ImagePath = "";
    private static File f;
    private static int Take_Photo = 2;
    private static String str_randomnumber = "";
    static String str_Camera_Photo_ImageName = "";
    public static String str_SaveFolderName;
    private static File wallpaperDirectory;
    Bitmap bitmap;
    int storeposition = 0;
    public static GridView gridview;
    public static ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.syllabus_fragment,container,false);
          imageView = (ImageView) v.findViewById(R.id.imageView1);
         Button button = (Button) v.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                str_SaveFolderName = Environment
                        .getExternalStorageDirectory()
                        .getAbsolutePath()
                        + "/Syllabus";
                str_randomnumber = String.valueOf(nextSessionId());
                wallpaperDirectory = new File(str_SaveFolderName);
                if(!wallpaperDirectory.exists())
                    wallpaperDirectory.mkdirs();
                str_Camera_Photo_ImageName = str_randomnumber
                        +".jpg";
                str_Camera_Photo_ImagePath = str_SaveFolderName
                        +"/"+str_randomnumber+".jpg";
                System.err.println(" str_Camera_Photo_ImagePath "
                + str_Camera_Photo_ImagePath);
                f = new File(str_Camera_Photo_ImagePath);
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra
                        (MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(f)),
                Take_Photo);
                System.err.println("f"+f);
            }
        });


        return v;
    }
    public String nextSessionId(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == Take_Photo){
            String filePath = null;

            filePath = str_Camera_Photo_ImagePath;
            if (filePath != null){
                Bitmap faceView = ( new_decode(new File(
                        filePath)));
                imageView.setImageBitmap(faceView);
            }else{
                bitmap = null;
            }
        }
    }
    public static Bitmap new_decode(File f){
        o.inJustDecodeBounds = true;
        o.inDither = false;
        o.inPurgeable = true;
        o.inInputShareable = true;

        try{
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
        }catch (FileNotFoundException e1){
            e1.printStackTrace();
        }

        final int REQUIRED_SIZE = 300;
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while(true){
            if (width_tmp/1.5<REQUIRED_SIZE&&height_tmp/1.5<REQUIRED_SIZE)
                break;
            width_tmp /= 1.5;
            height_tmp /= 1.5;
            scale *= 1.5;
        }
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o.inDither = false;
        o.inPurgeable = true;
        o.inInputShareable = true;

        try{
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(f),null,null);
                    System.out.println("IW" + width_tmp);
            System.out.println("IHH"+height_tmp);
            int iW = width_tmp;
            int iH = height_tmp;
            return  Bitmap.createScaledBitmap(bitmap, iW, iH, true);
        }catch (OutOfMemoryError e){
            e.printStackTrace();
            System.gc();
            return null;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
