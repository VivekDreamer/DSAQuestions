class POTD_MissingAndRepeating {
    int[] findTwoElement(int a[]) {
        int n = a.length;
        int xorNumber = 0;
        for(int i = 0; i < n; i++){
            xorNumber ^= a[i];
            xorNumber ^= (i+1);
        }   
        int bitNumber = xorNumber & ~(xorNumber-1);
        int zeroes = 0;
        int ones = 0;
        for(int i = 0; i < n; i++){
            if((bitNumber & a[i]) != 0) ones = ones ^ a[i];
            else zeroes = zeroes ^ a[i];
        }
        for(int i = 1; i <= n; i++){
            if((bitNumber & i) != 0) ones = ones ^ i;
            else zeroes = zeroes ^ i;
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == zeroes) cnt++;
        }
        if(cnt == 2) return new int[]{zeroes,ones};
        else return new int[]{ones,zeroes};
    }
}
