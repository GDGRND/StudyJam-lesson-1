package ru.webant.studyjam.utilRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.webant.studyjam.R;

/**
 * Created by vdaron on 19.08.17.
 */

public class ItemEmptyViewHolder extends Node.Item {
    public ItemEmptyViewHolder(View itemView) {
        super(itemView);
    }

    static Node.Creator getCreator() {
        return new Node.Creator() {
            @Override
            public Node.Item create(ViewGroup parent) {
                return new ItemEmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false));
            }
        };
    }
}
