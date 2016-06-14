package com.dreamliner.dragrv.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamliner.dragrv.R;
import com.dreamliner.dragrv.model.Item;
import com.dreamliner.dragrv.util.CircleTransform;
import com.dreamliner.rvhelper.adapter.BaseAdapter;
import com.squareup.picasso.Picasso;

/**
 * @author chenzj
 * @Title: PicAdapter
 * @Description: 类的描述 - 图片显示的adapter
 * @date 2016/6/14 09:52
 * @email admin@chenzhongjin.cn
 */
public class PicAdapter extends BaseAdapter<Item, PicAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getView(R.layout.item_list, parent));
    }

    @Override
    protected void bindView(ViewHolder viewHolder, int i) {
        Item item = getItem(i);
        viewHolder.setName(item.getName()); // Name
        viewHolder.setDescription(item.getDescription()); // Description
        viewHolder.setImage(item.getIdImage()); // Image
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUser;
        TextView tvName, tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ivUser = (ImageView) itemView.findViewById(R.id.ivUser);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }

        public void setName(String name) {
            tvName.setText(name);
        }

        public void setDescription(String description) {
            tvDescription.setText(description);
        }

        public void setImage(int idImage) {
            Picasso.with(ivUser.getContext()).
                    load(idImage).
                    centerCrop().
                    resize(60, 60).
                    transform(new CircleTransform()).
                    into(ivUser);
        }
    }

}
