/*
 Copyright 2013 Tonic Artos

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.xinlan.gridviewdemo;

import java.util.List;
import java.util.Map;

import com.xinlan.gridviewdemo.R;
import com.xinlan.widget.stickygridheaders.StickyGridHeadersSimpleAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Tonic Artos
 * @param <T>
 */
public class StickyGridHeadersSimpleArrayAdapter extends BaseAdapter implements
        StickyGridHeadersSimpleAdapter
{
    private LayoutInflater mInflater;
    private List<Map<String, String>> mItems;

    public StickyGridHeadersSimpleArrayAdapter(Context context,
            List<Map<String, String>> items)
    {
        init(context, items);
    }

    @Override
    public boolean areAllItemsEnabled()
    {
        return false;
    }

    @Override
    public int getCount()
    {
        return mItems.size();
    }

    @Override
    public long getHeaderId(int position)
    {
        Map<String, String> item = getItem(position);
        return Long.parseLong(item.get("head"));
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent)
    {
        HeadHolder holder;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.item2, parent, false);
            holder = new HeadHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }
        else
        {
            holder = (HeadHolder) convertView.getTag();
        }
        
        if(position==0)
        {
            holder.img.setVisibility(View.VISIBLE);
        }else{
            holder.img.setVisibility(View.GONE);
        }
        return convertView;
    }

    @Override
    public Map<String, String> getItem(int position)
    {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.item, parent, false);

        }

        return convertView;
    }

    private void init(Context context, List<Map<String, String>> items)
    {
        this.mItems = items;
        mInflater = LayoutInflater.from(context);
    }

    protected class HeadHolder
    {
        public TextView text;
        public ImageView img;
    }
}// end class
