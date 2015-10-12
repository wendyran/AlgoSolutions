/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find 
 * the length of shortest transformation sequence from beginWord to endWord, 
 * such that:

 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {

    int result = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, 
            Set<String> wordList) {
        return dfs(beginWord, endWord, wordList, 0);
    }

    public void dfs(String cur, String endWord, Set<String> wordList, int count) {
        if (cur.equals(endWord)) {
            count++;
            result = Math.min(result, count);
            return;
        }
        char[] array = cur.toCharArray();
        char[] tmp = cur.toCharArray();
        for (int i = 0; i < tmp.length; ++i) {
            for (char c = 'a'; c <= 'z'; ++c) {
                tmp[i] = c;
                String s = new String(tmp);
                if (wordList.contains(s)) {
                    count++;
                    wordList.remove(s);
                    dfs(s, endWord, wordList, count);
                    wordList.add(s);
                }
                tmp[i] = array[i];
            }
        }
    }

}