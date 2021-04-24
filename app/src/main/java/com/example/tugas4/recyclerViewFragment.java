package com.example.tugas4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link recyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recyclerViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public recyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static recyclerViewFragment newInstance(String param1, String param2) {
        recyclerViewFragment fragment = new recyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView phpRecycler;

        ArrayList<MainModel> mainModels;
        MainAdapter mainAdapter;

        View view = inflater.inflate(R.layout.fragment_recycler_view, container,false);

        phpRecycler = view.findViewById(R.id.rv_php);

        Integer[] phpFrameworkLogo = {R.drawable.phpcake,
                R.drawable.phpcodeigniter,
                R.drawable.phplaravel,
                R.drawable.phpsymfony};

        String[] phpFrameworkName = {"Cake", "CodeIgniter", "Laravel", "Symfony"};

        String[] phpDetail = {
                "CakePHP 4.0.0 is as tasty as other major CakePHP releases but will now require you to use PHP 7.2. With a refreshed application skeleton design, CakePHP 4.0.0 comes with a streamlined API making your development and application faster. While 4.0 contains a number of breaking changes we have prepared an exhaustive migration guide covering all the deprecated and removed features as well as highlighting the shiny new features.",
                "CodeIgniter is a powerful PHP framework with a very small footprint, built for developers who need a simple and elegant toolkit to create full-featured web applications.",
                "Laravel is a web application framework with expressive, elegant syntax. A web framework provides a structure and starting point for creating your application, allowing you to focus on creating something amazing while we sweat the details. Laravel strives to provide an amazing developer experience, while providing powerful features such as thorough dependency injection, an expressive database abstraction layer, queues and scheduled jobs, unit and integration testing, and more. Whether you are new to PHP or web frameworks or have years of experience, Laravel is a framework that can grow with you. We'll help you take your first steps as a web developer or give you a boost as you take your expertise to the next level. We can't wait to see what you build.",
                "Symfony is a set of PHP Components, a Web Application framework, a Philosophy, and a Community — all working together in harmony.",
        };

        mainModels = new ArrayList<>();
        for (int i = 0; i<phpFrameworkLogo.length; i++){
            MainModel model = new MainModel(phpFrameworkLogo[i], phpFrameworkName[i], phpDetail[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false
        );

        phpRecycler.setLayoutManager(layoutManager);
        phpRecycler.setItemAnimator(new DefaultItemAnimator());


        mainAdapter = new MainAdapter(mainModels,getContext());

        phpRecycler.setAdapter(mainAdapter);
        return view;
    }
}