package com.example.administrator.myapplication.multi_select;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.library.ItemViewProvider;

import java.util.Set;

import static java.lang.String.valueOf;

/**
 * Created by Administrator on 2016/11/23.
 */

public class SquareViewProvider extends ItemViewProvider<Square, SquareViewProvider.ViewHolder> {


    private final Set<Integer> selectedSet;

    public SquareViewProvider(Set<Integer> selectedSet) {
        this.selectedSet = selectedSet;
    }


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_square, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Square square) {
        holder.square=square;
        holder.squareView.setText(valueOf(square.number));
        holder.squareView.setSelected(square.isSelected);

    }

    public Set<Integer> getSelectedSet() {
        return selectedSet;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView squareView;
        private Square square;

        public ViewHolder(final View itemView) {
            super(itemView);
            squareView = (TextView) itemView.findViewById(R.id.square);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.setSelected(square.isSelected = !square.isSelected);

                    if (square.isSelected) {
                        selectedSet.add(square.number);
                    } else {
                        selectedSet.remove(square.number);
                    }

                }
            });
        }
    }
}
