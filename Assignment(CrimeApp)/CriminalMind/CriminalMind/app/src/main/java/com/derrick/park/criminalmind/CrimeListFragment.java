package com.derrick.park.criminalmind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecyclerListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

/**
 * Created by park on 2017-06-01.
 */

public class CrimeListFragment extends Fragment {


    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdater;
    public static final String EXTRA_key_Crime="EXTRA_key_Crime";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mAdater = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdater);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextViewTitle;
        public TextView mDate;
        public Crime mCrime;
        private ImageView msovedImageView;

        public CrimeHolder(View v) {
            super(v);
            mTextViewTitle=(TextView) itemView.findViewById(R.id.crime_title);
            mDate=(TextView) itemView.findViewById(R.id.crime_date);
            msovedImageView=(ImageView) itemView.findViewById(R.id.crimeSolved);
            mTextViewTitle.setOnClickListener(this);
            mDate.setOnClickListener(this);
        }
        public void bind (Crime crime){
            mCrime = crime;
            mTextViewTitle.setText(mCrime.getTitle());
            mDate.setText(mCrime.getDate().toString());
            msovedImageView.setVisibility(mCrime.isSolved()?View.VISIBLE:View.GONE);

        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(getActivity(),CrimeActivity.class);
            i.putExtra(EXTRA_key_Crime, mCrime.getId());
            startActivity(i);
        }
    }


    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimes;
        public View.OnClickListener listener;


        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        //MARK 2 DIFFERENT VIEWS  O: police  1: no police
//        @Override
//        public int getItemViewType (int index){
//
//            if (mCrimes.get(index).isRequiresPolice() == true) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // INFLATING ONE HOLDER 2 DIFFERENT VIEWS. O: police  1: no police
            View view = null;
//            if (viewType == 0) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_crime, parent, false);// OLD VIEW
//            } else if (viewType == 1) {
//                view = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_serious, parent, false); // NEW VIEW WITH BUTTONS
//            }
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime= mCrimes.get(position);
            holder.bind(crime);
        }

        public void setOnItemClickListener(View.OnClickListener listener) {
            this.listener = listener;
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

    }

}
