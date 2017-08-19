package ru.webant.studyjam.utilRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.webant.studyjam.R;

/**
 * Created by vdaron on 19.08.17.
 */

public class ItemDividerViewHolder extends Node.Item {
    public ItemDividerViewHolder(View itemView) {
        super(itemView);
    }

    static Node.Creator getCreator() {
        return new Node.Creator() {
            @Override
            public Node.Item create(ViewGroup parent) {
                return new ItemDividerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_divider, parent, false));
            }
        };
    }
}
