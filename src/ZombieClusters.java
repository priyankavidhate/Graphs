import java.util.List;

/*There are zombies in Seattle. Liv and Ravi are trying to track them down to find out who 
  is creating new zombies in an effort to prevent an apocalypse. 
  Other than the patient-zero zombies (who became so by mixing MaxRager and tainted Utopium), 
  new people only become zombies after being scratched by an existing zombie. Zombiism is transitive. 
  This means that if zombie 0 knows zombie 1 and zombie 1 knows zombie 2, then zombie 0 is connected 
  to zombie 2 by way of knowing zombie 1. A zombie cluster is a group of zombies who are directly or 
  indirectly linked through the other zombies they know, such as the one who scratched them or supplies 
  who them with brains.
We have a 2D array having n rows and n columns where each cell, zombies[A][B],
 denotes whether zombie A knows zombie B. 
 The diagram showing connectedness will be made up of a number of binary strings, characters 0 or 1. 
 Each of the characters in the string represents whether the zombie associated with a row element is
  connected to the zombie at that character's index. For instance, a zombie 0 with a 
  connectedness string '110' is connected to zombies 0 (itself) and zombie 1, but not to zombie 2. 
  The complete matrix of zombie connectedness is:

110
110
001
Zombies 0 and 1 are connected. Zombie 2 is not.

Sample Input 1:

4
1100
1110
0110
0001

Sample Output 1:
2
*/
public class ZombieClusters {
	static void dfs(int x, int n, List<String> zombies, boolean[] visited) {
		visited[x] = true;
		for (int i = 0; i < n; i++) {
			if (zombies.get(x).charAt(i) == '1' && !visited[i])
				dfs(i, n, zombies, visited);
		}
		return;
	}

	public static int zombieCluster(List<String> zombies) {
		int n = zombies.size();
		int res = 0;

		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {

			if (!visited[i]) {
				res++;
				dfs(i, n, zombies, visited);
			}
		}
		return res;
	}
}
