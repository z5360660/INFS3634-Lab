package au.edu.unsw.infs3634_lab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import au.edu.unsw.infs3634_lab.api.Crypto;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder> {

    ArrayList<Crypto> cryptoList;
    ClickListener mListener;

    public CryptoAdapter (ArrayList<Crypto> cryptos, ClickListener listener){
        cryptoList = cryptos;
        mListener = listener;

    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new CryptoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position) {
        Crypto cryptoItem = cryptoList.get(position);

        holder.list_name.setText(cryptoItem.getName());
        holder.list_value.setText("$" + cryptoItem.getPriceUsd());
        holder.list_change.setText(cryptoItem.getPercentChange1h() + "%");

        holder.itemView.setTag(cryptoItem.getSymbol());



    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public interface ClickListener {
        void onRowCLick(String symbol);
    }

    public class CryptoViewHolder extends RecyclerView.ViewHolder {
        TextView list_name, list_value, list_change;
        ImageView list_image;

        public CryptoViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_name);
            list_value = itemView.findViewById(R.id.list_value);
            list_change = itemView.findViewById(R.id.list_change);

            list_image = itemView.findViewById(R.id.list_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onRowCLick((String) view.getTag());
                }
            });

        }
    }

        }