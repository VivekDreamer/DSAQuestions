//https://www.geeksforgeeks.org/problems/print-anagrams-together/1
public class POTD_PrintAnagramsTogether {
  public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }

        // Step 2: Sort individual words in the original array
        for (int i = 0; i < arr.length; i++) {
            char[] charArray = arr[i].toCharArray();
            Arrays.sort(charArray);
            arr[i] = new String(charArray); // Store sorted word back in arr
        }

        // Step 3: Group anagrams
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[arr.length]; // To mark visited elements

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                ArrayList<String> group = new ArrayList<>();
                group.add(arr1[i]); // Add the original word to the group
                visited[i] = true;

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i].equals(arr[j])) {
                        group.add(arr1[j]); // Add matching original word to the group
                        visited[j] = true;
                    }
                }

                result.add(group);
            }
        }

        return result;
  }
}
