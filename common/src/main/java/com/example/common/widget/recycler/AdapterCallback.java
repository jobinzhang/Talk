package com.example.common.widget.recycler;

public interface AdapterCallback<Data> {

    public void update(Data data, RecyclerAdapter.ViewHolder<Data> viewHolder);
}
