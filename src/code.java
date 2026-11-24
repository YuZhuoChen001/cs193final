void main() {
    int num=Integer.parseInt(IO.readln("Number of assignments: "));
    String[] cun=new String[num];
    String[] da=new String[num];
    int[] note=new int[num];
    int[] times=new int[num];
    double total=0;
    for(int i=0;i<num;i++){
        String name = IO.readln("Name: ");
        String date=IO.readln("Deadline(MMDD): ");
        while(date.length()<4){
            IO.println("wrong date, try again");
            date=IO.readln("Deadline(MMDD): ");
        }
        int ti=Integer.parseInt(IO.readln("Need time in minutes: "));
        cun[i]=name+date;
        da[i]=date;
        note[i]=0;
        times[i]=ti;
        total+=ti;
    }
    Arrays.sort(da);
    for(int i=0;i<num;i++){
        for(int j=0;j<num;j++){
            if(cun[j].substring(cun[j].length()-4).equals(da[i]) && note[j]==0){
                IO.println("The NO."+(i+1)+" assignment: "+cun[j].substring(0,cun[j].length()-4));
                IO.println("Due: "+da[i]);
                IO.println("Need time: "+times[i]+", "+String.format("%.2f", times[i]/total*100)+"% of total needed time");
                note[j]=1;
            }
        }
    }
}
