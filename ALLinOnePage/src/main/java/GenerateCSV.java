import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GenerateCSV {

    public static void main(String[] args) throws IOException {
        
        
        BufferedReader bufferedReader  = new BufferedReader(new FileReader(new File("C:\\Users\\91953\\Desktop\\Book1.xlsx")));
        String line="";
        List<String> nameList = new ArrayList<>();
        List<String> gen = new ArrayList<>();
        int i = 0;
        while ((line = bufferedReader.readLine())!=null) {
            if(i == 0) {
                i=1;
            }else {
                nameList.add(line.split(",")[0]);
                gen.add(line.split(",")[1]);
            }
        }
        
        
        PrintWriter printWriter = new PrintWriter("C:\\Users\\91953\\Desktop\\data.csv");
        
        List<String> Psychologist = Arrays.asList(
                "Neglect",
                "Physical",
                "Sexual",
                "Emotional",
                "Grief", 
                "Parents",
                "Friends",
                "Children",
                "Relatives",
                "Divorce",
                "Relationship_issues",
                "Soft_skills",
                "Decision_making",
                "Problem_solving_skills",
                "Self_esteem",
                "Confidence",
                "Sexual_curiosity",
                "LGBT",
                "Porn",
                "Cross_dressing",
                "Motivation",
                "Anger",
                "Fear",
                "Bullying",
                "Parenting",
                "Broken_heart",
                "Marriage_issues",
                "Premarital_issues",
                "Extra_marital_affair",
                "Procrastination",
                "Office_stress",
                "Unemployed",
                "Shyness",
                "Mood_swings",
                "Child_behavior",
                "Loneliness",
                "Financial"
                );
        
        List<String> Psychiatrist = Arrays.asList(
                    "Sexual_problem",
                    "Body_problem",
                    "Mental_health",
                    "Mental_health_conditions",
                    "Masturbation",
                    "Chemical_addiction",
                    "Alchohol_addiction",
                    "Drug_addiction",
                    "Smoking",
                    "Porn",
                    "Stress",
                    "Anxiety",
                    "Panic",
                    "LGBT",
                    "Obsessive_compulsive_phobia",
                    "Phobia",
                    "Depression",
                    "Fear",
                    "Anger",
                    "Bipolar",
                    "Mood",
                    "Mood_swings",
                    "Eating",
                    "Personality",
                    "Psychotic",
                    "Post_traumatic",
                    "Schizophrenia",
                    "Sleeping",
                    "Insomnia",
                    "Low_confidence",
                    "Self_doubt",
                    "Pressure",
                    "Addiction",
                    "Concentration",
                    "Motivation",
                    "Empathy",
                    "Social_anxiety_disorde");
        
        List<String> Career_guide = Arrays.asList(
                "Interview_preparation",
                "Jobless",
                "Entrepreneurship",
                "Worklife_balance",
                "Time_management",
                "Career_Confusion",
                "Learning",
                "Career_shift",
                "Financial",
                "Exam_support",
                "Concentration",
                "Unemployed",
                "Competitive_exam_support",
                "Motivation",
                "Communication",
                "Critical_thinking",
                "People_managing",
                "Administrative_skills",
                "Change_management",
                "Innovation",
                "Providing_feedback",
                "Perseverance",
                "Studying",
                "Flexibility",
                "Managing_stress");
        
        StringBuilder builder = new StringBuilder();
        
        Set<String> name = new HashSet<>();
        int count = 1;
        
        
        for (int j = 0; j < 30000; j++) {
            int  nameIn =  (int) ((Math.random() * (nameList.size()-1 - 0)) + 0);
            
            int type = (int) ((Math.random() * (3 - 0)) + 0);
//            System.out.println(type);
            if (type == 0) {
                
                Set<Integer> type0 = new HashSet<>();
                int number = (int) ((Math.random() * (7 - 0)) + 3);
                StringBuilder cat = new StringBuilder();
                while (type0.size()!=number) {
                    int typ = (int) ((Math.random() * (Psychologist.size()-1 - 0)) + 0);
                    if(type0.add(typ)) {
                        cat.append(Psychologist.get(typ));
                        cat.append(" | ");
                    }
                }
                Random r = new Random();
                double rating =  (r.nextInt((int)((6-1)*10+1))+0*10) / 10.0;
                int con = (int) ((Math.random() * (100 - 0)) + 20);
                if(name.add(nameList.get(nameIn))) {
                    builder.append(count++);
                    builder.append(",");
                    builder.append(nameList.get(nameIn));
                    builder.append(",");
                    builder.append(gen.get(nameIn));
                    builder.append(",");
                    builder.append("Psychologist");
                    builder.append(",");
                    builder.append(cat);
                    builder.append(",");
                    builder.append(rating);
                    builder.append(",");
                    builder.append(con);
                    builder.append("\n");
                }
            }else if (type == 1) {
                Set<Integer> type0 = new HashSet<>();
                int number = (int) ((Math.random() * (7 - 0)) + 3);
                StringBuilder cat = new StringBuilder();
                while (type0.size()!=number) {
                    int typ = (int) ((Math.random() * (Psychiatrist.size()-1 - 0)) + 0);
                    if(type0.add(typ)) {
                        cat.append(Psychiatrist.get(typ));
                        cat.append(" | ");
                    }
                }
                Random r = new Random();
                double rating =  (r.nextInt((int)((6-1)*10+1))+0*10) / 10.0;
                int con = (int) ((Math.random() * (100 - 0)) + 20);
                if(name.add(nameList.get(nameIn))) {
                    builder.append(count++);
                    builder.append(",");
                    builder.append(nameList.get(nameIn));
                    builder.append(",");
                    builder.append(gen.get(nameIn));
                    builder.append(",");
                    builder.append("Psychiatrist");
                    builder.append(",");
                    builder.append(cat);
                    builder.append(",");
                    builder.append(rating);
                    builder.append(",");
                    builder.append(con);
                    builder.append("\n");
                }
            }else if (type == 2) {
                Set<Integer> type0 = new HashSet<>();
                int number = (int) ((Math.random() * (6 - 0)) + 3);
                StringBuilder cat = new StringBuilder();
                while (type0.size()!=number) {
                    int typ = (int) ((Math.random() * (Career_guide.size()-1 - 0)) + 0);
                    if(type0.add(typ)) {
                        cat.append(Career_guide.get(typ));
                        cat.append(" | ");
                    }
                }
                Random r = new Random();
                double rating =  (r.nextInt((int)((6-1)*10+1))+0*10) / 10.0;
                int con = (int) ((Math.random() * (100 - 0)) + 20);
                if(name.add(nameList.get(nameIn))) {
                    builder.append(count++);
                    builder.append(",");
                    builder.append(nameList.get(nameIn));
                    builder.append(",");
                    builder.append(gen.get(nameIn));
                    builder.append(",");
                    builder.append("Career_guide");
                    builder.append(",");
                    builder.append(cat);
                    builder.append(",");
                    builder.append(rating);
                    builder.append(",");
                    builder.append(con);
                    builder.append("\n");
                }
            }
            
            
           
            
        }
            
        printWriter.write(builder.toString());
        printWriter.close();
        
    }
}









