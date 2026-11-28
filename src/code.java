import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
void main() throws IOException{
    int num=Integer.parseInt(IO.readln("Number of assignments: "));
    ArrayList<String> cun=new ArrayList<String>();
    ArrayList<String> da=new ArrayList<String>();
    ArrayList<String> da2=new ArrayList<String>();
    ArrayList<Integer> note=new ArrayList<Integer>();
    ArrayList<Integer> times=new ArrayList<Integer>();
    ArrayList<Double> score=new ArrayList<Double>();
    ArrayList<Double> score2=new ArrayList<Double>();
    ArrayList<Integer> importance=new ArrayList<Integer>();
    double ratio1=0.2;
    double ratio2=0.3;
    double ratio3=0.5;
    double total=0;
    for(int i=0;i<num;i++){
        String name = IO.readln("Name: ");
        String date="";
        int yes=0;
        while(yes==0){
            try{
                date=IO.readln("Deadline(MMDD): ");
                int iii=Integer.parseInt(date);
                yes=1;
                if(date.length()!=4){
                    IO.println("wrong date, try again");
                    yes=0;
                }
            }catch (NumberFormatException e){
                IO.println("Wrong input, try again");
                
            }
        }
        int ti=0;
        yes=0;
        while(yes==0){
            try{
                ti=Integer.parseInt(IO.readln("Need time in minutes: "));
                yes=1;
            }catch (NumberFormatException e){
                IO.println("Wrong input, try again");
            }
        }
        int imp=0;
        yes=0;
        while(yes==0){
            try{
                imp=Integer.parseInt(IO.readln("What is the importance 1-20 "));
                yes=1;
                if(imp<1 || imp>20){
                    IO.println("Wrong importance answer");
                    yes=0;
                }
            }catch (NumberFormatException e){
                IO.println("Wrong input, try again");
            }
        }
        
        importance.add(imp);
        cun.add(name);
        da.add(date);
        da2.add(date);
        note.add(0);
        times.add(ti);
        total+=ti;
    }
    Collections.sort(da);
    for(int i=0;i<num;i++){
        double sc=0.0;
        int rank=0;
        for(int j=0;j<num;j++){
            if(da2.get(i).equals(da.get(j)) && note.get(j)==0){
                note.set(j,1);
                rank=j;
                break;
            }
        }
        sc+=Math.abs(num-rank)*ratio1;
        sc+=times.get(i)*ratio2;
        sc+=importance.get(i)*ratio3;
        score.add(sc);
        score2.add(sc);
    }
    for(int i=0;i<num;i++){
        note.set(i,0);
    }
    Collections.sort(score);
    for(int i=num-1;i>=0;i--){
        for(int j=0;j<num;j++){
            if(Math.abs(score.get(i)-score2.get(j))<0.0001){
                if(note.get(j)==0){
                    note.set(j,1);
                    IO.println("The NO."+(num-i)+" assignment: "+cun.get(j));
                    IO.println("Due: "+da2.get(j));
                    IO.println("Need time: "+times.get(j)+", "+String.format("%.2f", times.get(j)/total*100)+"% of total needed time");
                }
            }
        }
    }
    for(int i=0;i<num;i++){
        note.set(i,0);
    }
    int pd=0;
    while(pd!=6){
        IO.println("Press 1: Add an assignment");
        IO.println("Press 2: Finish an assignment");
        IO.println("Press 3: Make a new schdule");
        IO.println("Press 4: Change the ranking structure");
        IO.println("Press 5: Store data in a file");
        IO.println("Press 6: Quit");
        int ye=0;
        while(ye==0){
            try{
                pd=Integer.parseInt(IO.readln("Your choice: "));
                ye=1;
            }catch (NumberFormatException e){
                IO.println("Not a number");
            }
        }
        if(pd==1){
            num+=1;
            String name = IO.readln("Name: ");
            String date="";
            int yes=0;
            while(yes==0){
                try{
                    date=IO.readln("Deadline(MMDD): ");
                    int iii=Integer.parseInt(date);
                    yes=1;
                    if(date.length()!=4){
                        IO.println("wrong date, try again");
                        yes=0;
                    }
                }catch (NumberFormatException e){
                    IO.println("Wrong input, try again");
                    
                }
            }
            yes=0;
            int ti=0;
            while(yes==0){
                try{
                    ti=Integer.parseInt(IO.readln("Need time in minutes: "));
                    yes=1;
                }catch (NumberFormatException e){
                    IO.println("Wrong input, try again");
                }
            }
            int imp=0;
            yes=0;
            while(yes==0){
                try{
                    imp=Integer.parseInt(IO.readln("What is the importance 1-20 "));
                    yes=1;
                    if(imp<1 || imp>20){
                        IO.println("Wrong importance answer");
                        yes=0;
                    }
                }catch (NumberFormatException e){
                    IO.println("Wrong input, try again");
                }
            }
            importance.add(imp);
            cun.add(name);
            da.add(date);
            da2.add(date);
            note.add(0);
            times.add(ti);
            total+=ti;
            for(int i=0;i<num;i++){
                note.set(i,0);
            }
            Collections.sort(da);
            double sc=0.0;
            int rank=0;
            for(int j=0;j<num;j++){
                if(da.get(j).equals(date)){
                    rank=j;
                    break;
                }
            }
            sc+=Math.abs(num-rank)*ratio1;
            sc+=ti*ratio2;
            sc+=imp*ratio3;
            score.add(sc);
            score2.add(sc);
        }else if(pd==2){
            String na=IO.readln("assignment name: ");
            int pdd=0;
            for(int ii=0;ii<num;ii++){
                if(cun.get(ii).equals(na)){
                    pdd=1;
                    String dd=da2.get(ii);
                    for(int j=0;j<num;j++){
                        if(da.get(j).equals(dd)){
                            da.remove(j);
                            break;
                        }
                    }
                    importance.remove(ii);
                    total-=times.get(ii);
                    cun.remove(ii);
                    da2.remove(ii);
                    note.remove(ii);
                    times.remove(ii);
                    score.clear();
                    score2.clear();
                    Collections.sort(da);
                    num-=1;
                    for(int i=0;i<num;i++){
                        double sc=0.0;
                        int rank=0;
                        for(int j=0;j<num;j++){
                            if(da2.get(i).equals(da.get(j)) && note.get(j)==0){
                                note.set(j,1);
                                rank=j;
                                break;
                            }
                        }
                        sc+=Math.abs(num-rank)*ratio1;
                        sc+=times.get(i)*ratio2;
                        sc+=importance.get(i)*ratio3;
                        score.add(sc);
                        score2.add(sc);
                    }
                    for(int i=0;i<num;i++){
                        note.set(i,0);
                    }
                }
            }
            if(pdd==1){
                IO.println("Removed. ");
            }else{
                IO.println("Wrong name.");
            }
        }else if(pd==3){
            for(int i=0;i<num;i++){
                note.set(i,0);
            }
            Collections.sort(score);
            for(int i=num-1;i>=0;i--){
                for(int j=0;j<num;j++){
                    if(Math.abs(score.get(i)-score2.get(j))<0.0001){
                        if(note.get(j)==0){
                            note.set(j,1);
                            IO.println("The NO."+(num-i)+" assignment: "+cun.get(j));
                            IO.println("Due: "+da2.get(j));
                            IO.println("Need time: "+times.get(j)+", "+String.format("%.2f", times.get(j)/total*100)+"% of total needed time");
                        }
                    }
                }
            }
            for(int i=0;i<num;i++){
                note.set(i,0);
            }
        }else if(pd==4){
            int yes=0;
            IO.println("The current ratio of deadline is "+(ratio1)*100);
            double fi=0.0;
            while(yes==0){
                try{
                    fi=Double.parseDouble(IO.readln("Set new ration 0-"+Math.round((1-ratio2-ratio3)*100)+": "));
                    yes=1;
                    if(fi>(1-ratio2-ratio3)*100 || fi<0){
                        IO.println("Wrong number, try again");
                        yes=0;
                    }
                }catch (NumberFormatException e){
                    IO.println("Wrong input, try again");
                }
                
            }

            yes=0;
            ratio1=fi/100;
            IO.println("The current ratio of needed time is "+(ratio2)*100);
            double se=0.0;
            while(yes==0){
                try{
                    se=Double.parseDouble(IO.readln("Set new ration 0-"+Math.round((1-ratio1-ratio3)*100)+": "));
                    yes=1;
                    if(se>(1-ratio1-ratio3)*100 || se<0){
                        IO.println("Wrong number, try again");
                        yes=0;
                    }
                }catch (NumberFormatException e){
                    IO.println("Wrong input, try again");
                }
            }
            yes=0;
            ratio2=se/100;
            IO.println("The current ratio of importance is "+(ratio3)*100);
            double th=0.0;
            while(yes==0){
                try{
                    th=Double.parseDouble(IO.readln("Set new ration 0-"+Math.round((1-ratio1-ratio2)*100)+": "));
                    yes=1;
                    if(th>(1-ratio1-ratio2)*100 || th<0){
                        IO.println("Wrong number, try again");
                        yes=0;
                    }
                }catch (NumberFormatException e){
                    IO.println("Wrong input, try again");
                }
            }
            yes=0;
            ratio3=th/100;
            score2.clear();
            score.clear();
            Collections.sort(da);
            for(int i=0;i<num;i++){
                double sc=0.0;
                int rank=0;
                for(int j=0;j<num;j++){
                    if(da2.get(i).equals(da.get(j)) && note.get(j)==0){
                        note.set(j,1);
                        rank=j;
                        break;
                    }
                }
                sc+=Math.abs(num-rank)*ratio1;
                sc+=times.get(i)*ratio2;
                sc+=importance.get(i)*ratio3;
                score.add(sc);
                score2.add(sc);
            }
            for(int i=0;i<num;i++){
                note.set(i,0);
            }
        }else if(pd==5){
            PrintWriter pw = new PrintWriter(new FileOutputStream("todolist.txt"));
            for(int i=0;i<num;i++){
                note.set(i,0);
            }
            Collections.sort(score);
            for(int i=num-1;i>=0;i--){
                for(int j=0;j<num;j++){
                    if(Math.abs(score.get(i)-score2.get(j))<0.0001){
                        if(note.get(j)==0){
                            note.set(j,1);
                            pw.println("The NO."+(num-i)+" assignment: "+cun.get(j));
                            pw.println("Due: "+da2.get(j));
                            pw.println("Need time: "+times.get(j)+", "+String.format("%.2f", times.get(j)/total*100)+"% of total needed time");
                        }
                    }
                }
            }
            for(int i=0;i<num;i++){
                note.set(i,0);
            }
            pw.close();
        }else{
            if(pd==6){
                continue;
            }
            IO.println("Wrong input, try again");
        }
    }
}
