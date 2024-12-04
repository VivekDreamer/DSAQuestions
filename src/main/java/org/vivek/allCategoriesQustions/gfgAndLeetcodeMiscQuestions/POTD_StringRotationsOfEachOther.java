// https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
public class POTD_StringRotationsOfEachOther {
    public static boolean areRotations(String s1, String s2 ){
        StringBuilder sb=new StringBuilder();
        sb.append(s1);
        sb.append(s1);
        return sb.lastIndexOf(s2) >=0;
    }
}
