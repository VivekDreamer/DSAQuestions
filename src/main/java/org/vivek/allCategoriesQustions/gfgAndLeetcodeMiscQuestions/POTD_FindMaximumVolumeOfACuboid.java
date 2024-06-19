// https://www.geeksforgeeks.org/problems/magical-box5306/1
class POTD_FindMaximumVolumeOfACuboid {
    double maxVolume(double perimeter, double area) {
        double l = (double)(perimeter - Math.sqrt(perimeter * perimeter - 24 * area))/12;
        double h = (perimeter / 4) - (2 * (l));
        return l * l * h;
    }
}
