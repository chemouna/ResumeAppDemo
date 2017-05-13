package com.example.resume.resume;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.resume.R;
import com.example.resume.model.ResumeElement;
import java.util.ArrayList;
import java.util.List;

public class ResumeListView extends LinearLayout {

    @BindView(R.id.resume_list_rv) RecyclerView resumeListRv;

    public ResumeListView(Context context) {
        this(context, null);
    }

    public ResumeListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ResumeListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.resume_list_view, this, true);
        ButterKnife.bind(this, view);

        setupResumeList();
    }

    private void setupResumeList() {
        resumeListRv.setLayoutManager(
            new StaggeredGridLayoutManager(2, OrientationHelper.HORIZONTAL));
        ResumeAdapter resumeAdapter = new ResumeAdapter();
        resumeListRv.setAdapter(resumeAdapter);

        List<ResumeElement> items = getDummyData();
        resumeAdapter.setItems(items);
    }

    public List<ResumeElement> getDummyData() {
        List<ResumeElement> dummyData = new ArrayList<>();
        dummyData.add(ResumeElement.create("Ruby",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Ruby_logo.svg/1200px-Ruby_logo.svg.png",
            "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la"   + "\n"
                + " mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie "  + "\n"
                + "depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de "  + "\n"
                + "texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre "  + "\n"
                + "cinq siècles, mais s'est aussi adapté à la " + "\n" ));
        dummyData.add(ResumeElement.create("Bash",
            "http://www.pd4pic.com/images800_/bash-terminal-linux-unix-computer-prompt-ubuntu.png",
            "On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est "  + " \n "
                + "source de distractions, et empêche de se concentrer sur la mise en page elle-même. "  + " \n "
                + "L'avantage du Lorem Ipsum sur un texte générique" + " \n "));
        dummyData.add(ResumeElement.create("Java",
            "http://www.vectorsland.com/imgd/l12866-java-eps-logo-99090.png", "ontrairement à une opinion répandue,"  + " \n "
                + " le Lorem Ipsum n'est pas simplement du texte aléatoire. Il trouve ses racines dans une oeuvre de la "  + " \n "
                + "littérature latine classique datant de 45 av. J.-C., le rendant vieux de 2000 ans. Un professeur d" + " \n "));
        dummyData.add(ResumeElement.create("SQL",
            "http://www.opentuto.com/wp-content/uploads/2015/06/Introduction-to-SQL.png", "extrait d'un passage du"  + " \n "
                + " Lorem Ipsum, et en étudiant tous les usages de ce mot dans la littérature classique, découvrit la "  + " \n "
                + "source incontestable du Lorem Ipsum. Il provient en fait des sections 1.10.32 et 1.10.33 du \"De Finibus Bonorum "  + " \n "
                + "et Malorum\" (Des Suprêmes Biens et des Suprêmes " + " \n "));
        dummyData.add(ResumeElement.create("Python",
            "https://www.python.org/static/community_logos/python-logo-master-v3-TM.png", "Tous les générateurs de Lorem Ipsum "  + " \n "
                + "sur Internet tendent à reproduire le même extrait sans fin, ce qui fait de lipsum.com le seul vrai générateur de"  + " \n "
                + "Lorem Ipsum. Iil utilise un dictionnaire de plus de 200 mots latins" + " \n "));
        return dummyData;
    }
}
