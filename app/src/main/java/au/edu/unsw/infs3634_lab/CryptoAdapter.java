package au.edu.unsw.infs3634_lab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import au.edu.unsw.infs3634_lab.api.Crypto;
import au.edu.unsw.infs3634_lab.api.Datum;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder> implements Filterable {

    List<Datum> cryptoList;
    List<Datum> localDataListFiltered;
    ClickListener mListener;

    public CryptoAdapter (List<Datum> cryptos, ClickListener listener){
        cryptoList = cryptos;
        localDataListFiltered = cryptoList;
        mListener = listener;

    }

    public void Sort(int sortBy) {
        Collections.sort(localDataListFiltered, new Comparator<Crypto>() {
            @Override
            public int compare(Crypto c1, Crypto c2) {
                if (sortBy == 1) {
                return c1.getName().toLowerCase().compareTo(c2.getName().toLowerCase());

            }
            //if sort by is anything else that is not 1 then sort by price
            else {
                    //if sort by is 1 then sort by name
                Double c1Price = Double.parseDouble(c1.getPriceUsd());
                Double c2Price = Double.parseDouble(c2.getPriceUsd());
                return Double.compare(c1Price, c2Price);
            }

            }
        });
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new CryptoViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position) {
        Crypto cryptoItem = localDataListFiltered.get(position);

        holder.list_name.setText(cryptoItem.getName());
        holder.list_value.setText("$" + cryptoItem.getPriceUsd());
        holder.list_change.setText(cryptoItem.getPercentChange1h() + "%");

        holder.itemView.setTag(cryptoItem.getSymbol());



    }

    @Override
    public int getItemCount() {
        return localDataListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchQuery = (String) charSequence;
                if (searchQuery.isEmpty()) {
                    localDataListFiltered = cryptoList;
                }
                else {
                    ArrayList<Crypto> tempArray = new ArrayList<>();
                    for (Crypto item: cryptoList) {
                        if (item.getName().toLowerCase().contains(searchQuery)) {
                            tempArray.add(item);
                        }
                    }

                    localDataListFiltered = tempArray;

                }
                FilterResults results = new FilterResults();
                results.values = localDataListFiltered;

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                notifyDataSetChanged();

            }
        };
    }

    public interface ClickListener {
        void onRowCLick(String symbol);
    }

    public class CryptoViewHolder extends RecyclerView.ViewHolder {
        TextView list_name, list_value, list_change;
        ImageView list_image;

        public CryptoViewHolder(@NonNull View itemView, ClickListener listener) {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_name);
            list_value = itemView.findViewById(R.id.list_value);
            list_change = itemView.findViewById(R.id.list_change);

            list_image = itemView.findViewById(R.id.list_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String read = (String)view.getTag();
                    listener.onRowCLick((String) view.getTag());
                }
            });

        }
    }

        }