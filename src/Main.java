import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String moved(String s, int n){
        StringBuilder sb = new StringBuilder();
        for(int i =n; i<s.length();i++)
            sb.append(s.charAt(i));
        for(int i =0; i<n; i++)
            sb.append(s.charAt(i));

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static int countMoreThanOne(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int count =0, elementCount =0;
        for(int i =0, j=0; i< arr.length && j< arr.length; j++){
            if(arr[i]==arr[j])
                count++;
            else{
                i=j;
                j--;
                if(count>1)
                    elementCount++;
                count =0;
            }
        }
        if(count>1)
            elementCount++;
        System.out.println(elementCount);
        return elementCount;
    }

    public static int maxContagiousSum(int[] arr, int k){
        int maxSum = 0, sum = 0;

        for(int i = 0; i< k; i++) {
            sum = sum + arr[i];
        }
        if(maxSum < sum)
            maxSum = sum;

        for(int i=k; i< arr.length;i++)
        {
            sum = sum - arr[i-k] + arr[i];
            if(sum> maxSum)
                maxSum = sum;
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static int sumOfBoundaryElement(int[][] arr){
        int sum = 0;

        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[i].length;j++){
                if(i == 0 || i == arr.length-1){
                    sum = sum + arr[i][j];
                }
                else if(j == 0 || j == arr[i].length-1){
                    sum = sum + arr[i][j];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static int sumOfBoundaryElement2(int[][] arr){
        int sum = 0;
        int i=0;
        for(int[] a: arr){
            if(i==0 || i == arr.length -1)
                for(int k: a)
                    sum += k;
            else
                sum += a[0] + a[a.length - 1];
            i++;

        }
        System.out.println(sum);
        return sum;
    }

    public static int maximumPathSum(int[][] arr){
        int maxSum = 0;
        for(int i=0; i< arr.length; i++){
            int sum = arr[i][0];
            int k=i;
            System.out.println();
            System.out.print(arr[i][0] + "-> ");
            for(int j=0; j + 1 < arr[i].length;){
                if(k-1 >= 0 && j+1 < arr[i].length) {
                        k = k - 1;
                        j = j + 1;
                        System.out.print(arr[k][j] + "-> ");
                        sum += arr[k][j];
                }
                else if(k+1 < arr.length && j+1 < arr[i].length) {
                        k = k + 1;
                        j = j + 1;
                        System.out.print(arr[k][j] + "-> ");
                        sum += arr[k][j];
                }
                else
                    break;

            }
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println();
        System.out.println(maxSum);
        return maxSum;
    }

    public static String[] sortAlphabetically(int[] arr){
        String[] s = new String[arr.length];
        for(int i = 0; i< arr.length; i++){
            if(arr[i] > 0)
                s[i] = "+" + arr[i];
            else
                s[i] = "" + arr[i];
        }
        Arrays.sort(s);
        System.out.print(Arrays.toString(s));
        return s;
    }

    public static int[] twoSum(int[] arr, int sum){
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i< arr.length; i++)
        {
            if(hashMap.containsKey(sum - arr[i])) {
                System.out.println(Arrays.toString(new int[]{hashMap.get(sum - arr[i]), i}));
                return new int[]{hashMap.get(sum - arr[i]), i};
            }
            hashMap.put(arr[i], i);
        }
        return new int[2];
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;

        char[] c = s.toCharArray();
        char[] c1 = t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(c1);
        System.out.println(Arrays.equals(c1, c));
        return Arrays.equals(c1, c);
    }

    public static boolean isAnagram2(String s, String t){
        if(s.length() != t.length())
            return false;
        HashMap<Character, Integer> hashMap= new HashMap<>();

        for(int i = 0; i< s.length(); i++)
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);

        for(int i = 0; i< t.length(); i++) {
            if(!hashMap.containsKey(t.charAt(i)))
                return false;
            int count = hashMap.get(t.charAt(i));
            if(count - 1 <= 0)
                hashMap.remove(t.charAt(i));
            else
                hashMap.put(t.charAt(i), count - 1);
        }

        return hashMap.isEmpty();
    }

    public static int nonRepeatingIndex(String s){
        Map<Character, Integer> hashMap= new LinkedHashMap<>();
        Character g = null;

        for(int i = 0; i< s.length(); i++)
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);

        for(char c: hashMap.keySet()) {
            System.out.println("Key: " + c + " value: "+ hashMap.get(c));
            if (hashMap.get(c) == 1) {
                g = c;
                break;
            }
        }
        System.out.println(g);
        return g != null ? s.indexOf(g) : -1;
    }

    public static int[] mergeSortedArray(int[] a, int[] b){
        int [] mergedArray = new int[a.length + b.length];

        for(int i = 0, j= 0, k=0; k < mergedArray.length; k++)
        {
            if(i < a.length && j< b.length && a[i] < b[j]){
                mergedArray[k] = a[i];
                i++;
            }
            else if(j < b.length){
                mergedArray[k] = b[j];
                j++;
            }
            else{
                mergedArray[k] = a[i];
                i++;
            }
        }
        System.out.println(Arrays.toString(mergedArray));
        return mergedArray;
    }

    public static String reverseString(String word){
        String reverse = "";

        String[] words = word.split(" ");
        for(int i= words.length -1; i>=0; i--) {
            if(i== words.length -1)
                reverse = reverse.concat(words[i]);
            else
                reverse = reverse.concat(" " + words[i]);
        }

        return reverse;
    }

    public static int[] vowelsAndConsonants(String word){
        HashSet<Character> vowels = new HashSet<>(List.of(new Character[]{'a', 'e', 'i', 'o', 'u'}));
        int count = 0;
        for(char c: word.toCharArray())
            if(vowels.contains(c))
                count++;

        return new int[]{count, word.length() - count};
    }

    public static int longestSubstring(String word){
        int index = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        char[] stringToCharArray = word.toCharArray();
        int i = 0, j=0, maxSubstring = 0;

        for(i = 0, j = 0; j< stringToCharArray.length; j++){
            if(hashMap.containsKey(stringToCharArray[j])) {
                maxSubstring = Math.max(maxSubstring, j - i);
                i = Math.max(i, hashMap.get(stringToCharArray[j])  + 1);
            }
            hashMap.put(stringToCharArray[j], j);
        }
        maxSubstring = Math.max(maxSubstring, j - i);
        return maxSubstring;
    }

    public static List<Integer> spiralOrder(int[][] a){
        List<Integer> elements = new ArrayList<>();
        int top = 0, bottom = a.length -1;
        int left = 0, right = a[0].length - 1;

        while(top <= bottom && left <= right ){
            for(int j = left; j<= right; j++)
                elements.add(a[top][j]);
            top++;

            for(int k=top; k<= bottom; k++)
                elements.add(a[k][right]);
            right--;

            if(top<=bottom) {
                for (int j = right; j >= left; j--)
                    elements.add(a[bottom][j]);
                bottom--;
            }
            if(left<=right) {
                for (int k = bottom; k >= top; k--)
                    elements.add(a[k][left]);
                left++;
            }
        }
        return elements;
    }

    public static List<Integer> removeDuplicates(int[] a){

        List<Integer> nonDuplicate = new ArrayList<>();
        nonDuplicate.add(a[0]);
        for(int i=0,j = 1; j< a.length; j++)
        {
            if(a[i] != a[j]) {
                nonDuplicate.add(a[j]);
                i = j;
            }
        }

        return nonDuplicate;
    }

    public static int[] product(int[] a){
        int[] products = new int[a.length];

        for(int i =0; i< a.length; i++){
            int prod = 1;
            for(int j = 0; j< a.length; j++){
                if( i != j)
                    prod = prod * a[j];
            }
            products[i] = prod;
        }

        return products;
    }

    public static int[] product1(int[] a){
        int n = a.length;
        int[] result = new int[n];

        // Left products
        result[0] = 1;
        for(int i = 1; i < n; i++)
            result[i] = result[i-1] * a[i-1];

        // Right products
        int right = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] = result[i] * right;
            right = right * a[i];
        }

        return result;
    }

    public static int[][] rotate90(int[][] a){

        int[][] rotatedArray = new int[a.length][a.length];

        for(int i = 0; i< a.length; i++){
            for(int j =0; j< a[0].length; j++){
                rotatedArray[j][a.length -1 - i] = a[i][j];
            }
        }
        return rotatedArray;
    }

    public static boolean isPalindrome(String word){
        for(int i =0; i< word.length(); i++){
            char c = word.charAt(i);
            if(!((c>='a'&& c <= 'z') || (c>='A' && c <= 'Z') || (c>'0'&& c < '9')))
                word = word.replace(""+word.charAt(i), "");
        }

        char[] toCharArray= word.toLowerCase().toCharArray();

        for(int i =0, j= toCharArray.length -1; i<= j; i++,j--)
            if(toCharArray[i] != toCharArray[j])
                return false;

        System.out.println(word);
        return true;
    }



    public static boolean isBalanced(String s) {
        char[] sCharArray = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c: sCharArray){
            if(c == '(' || c== '{' || c=='[')
                stack.push(c);
            else if(c == ')' || c== '}' || c==']'){
                if(!stack.isEmpty()){
                    if((c==')' && stack.peek() == '(') || (c=='}' && stack.peek() == '{') || (c==']' && stack.peek() == '['))
                        stack.pop();
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printList();  // 1, 2, 3, 4
        list.reverse();
        list.printList();  // 4, 3, 2, 1
        System.out.println();
        System.out.println("Middle node is" + list.findMiddle().getValue());


        String s = "([)]";
        System.out.println("String " + s + " is valid: " + isBalanced(s));

        MyQueue queue = new MyQueue(List.of(1,2,3));
        System.out.println("First element in queue: " + queue.peek());
        System.out.println("Delete first element in queue: " + queue.pop());
        queue.push(4);
        System.out.println("First element in queue: " + queue.peek());

        moved("hello", 2);
        int[] a = {2, 1, 5, 1, 3, 2};
        countMoreThanOne(a);
        a = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(Arrays.toString(a));
        maxContagiousSum(a, 3);
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int[] i: arr)
            System.out.println(Arrays.toString(i));

        sumOfBoundaryElement(arr);
        sumOfBoundaryElement2(arr);
        maximumPathSum(arr);

        a = new int[]{5, -5, 0};
        sortAlphabetically(a);

        a = new int[]{2, 7, 11, 15};
        System.out.println();
        twoSum(a, 9);

        isAnagram("anagram", "nagaram");

        nonRepeatingIndex("leetcode");

        int[] arr2 = {1, 2, 3}, arr1 = {4, 5, 6};
        System.out.println("arr1" + Arrays.toString(arr1));
        System.out.println("arr2" + Arrays.toString(arr2));
        mergeSortedArray(arr1, arr2);

        System.out.println();
        System.out.println();
        System.out.println(reverseString("hello world"));

        System.out.println(Arrays.toString(vowelsAndConsonants("aeiou")));

        System.out.println("tmmzuxt: " + longestSubstring("tmmzuxt"));

        arr = new int[][]{{1, 2, 3, 10}, {4, 5, 6, 11}, {7, 8, 9, 12}};
//        arr = new int[][]{{1, 2, 3, 10}, {4, 5, 6, 11}, {7, 8, 9, 12}, {13,14, 15, 16}};
        for(int[] k: arr)
            System.out.println(Arrays.toString(k));

        System.out.println( Arrays.toString(spiralOrder(arr).toArray()));

        a = new int[]{1,2};
        System.out.println(removeDuplicates(a).toString());

        a= new int[]{ 1, 2, 3, 4};
        System.out.println( Arrays.toString(a));
        System.out.println(Arrays.toString(product(a)));

        System.out.println();
        arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13,14, 15, 16}};;
        for(int[] k: arr)
            System.out.println(Arrays.toString(k));

        System.out.println();
        int[][] rotated = rotate90(arr);
        for(int[] k: rotated)
            System.out.println(Arrays.toString(k));

        System.out.println();
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }
}