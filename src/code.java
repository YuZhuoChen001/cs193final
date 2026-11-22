void main() {
    int num=Integer.parseInt(IO.readln("Number of assignments: "));
    String[] cun=new String[num];
    String[] da=new String[num];
    int[] note=new int[num];
    for(int i=0;i<num;i++){
        String name = IO.readln("Name: ");
        String date=IO.readln("Deadline(MMDD): ");
        cun[i]=name+date;
        da[i]=date;
        note[i]=0;
    }
    Arrays.sort(da);
    for(int i=0;i<num;i++){
        for(int j=0;j<num;j++){
            if(cun[j].substring(cun[j].length()-4).equals(da[i]) && note[j]==0){
                IO.println("The NO."+(i+1)+" assignment: "+cun[j].substring(0,cun[j].length()-4));
                IO.println("Due: "+da[i]);
                note[j]=1;
            }
        }
    }
}
