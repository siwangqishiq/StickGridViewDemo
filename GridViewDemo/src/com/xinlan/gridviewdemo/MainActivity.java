package com.xinlan.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinlan.widget.stickygridheaders.StickyGridHeadersGridView;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;

public class MainActivity extends Activity
{
    private StickyGridHeadersGridView gridView;
    private List<Map<String,String>> list;

    // private GridAdapter adapter;
    static class Node
    {
        int data;
        int headId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Map<String,String>>();
        Map<String,String> map1 = new HashMap<String,String>();
        map1.put("head", "1");
        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("head", "1");
        list.add(map1);
        list.add(map2);
        
        Map<String,String> map3 = new HashMap<String,String>();
        map3.put("head", "1");
        Map<String,String> map4 = new HashMap<String,String>();
        map4.put("head", "1");
        list.add(map3);
        list.add(map4);
        
        for(int i=0;i<20;i++)
        {
            Map<String,String> map = new HashMap<String,String>();
            map.put("head", "2");
            
            list.add(map);
        }//end for i
        

        List<String> data = new ArrayList<String>();
        data.add("Afghanistan");

        gridView = (StickyGridHeadersGridView) findViewById(R.id.gridview);
        gridView.setAdapter(new StickyGridHeadersSimpleArrayAdapter(this, list));
    }
}// end class
