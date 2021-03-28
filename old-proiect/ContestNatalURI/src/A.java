import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// DONE

public class A {

	static class Team implements Comparable<Team> {
		String name;
		int [] medals; // {0 =>  ouro,1 => prata, 2 => broze}
		Team(String name, int[] medals) {
			this.name = name;
			this.medals = medals;
		}
		
		public void addMedals(int idx) {
			this.medals[idx] += 1;
		}

		@Override
		public int compareTo(Team team) {
			int o = team.medals[0] - this.medals[0];
			int p = team.medals[1] - this.medals[1];
			int b = team.medals[2] - this.medals[2];
			if(o == 0) {
				if(p == 0) {
					if(b == 0) {
						return this.name.compareTo(team.name);
					}
					return b;
				}
				return p; 
			} 
			return o;
		}
	}
	
	static Set<Team> teams = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
		String enter;
		try {
			int count = 0;
			while( (enter = buffer.readLine()) != null) {
				if( count > 0) {
					boolean hasTeam = false;
					Iterator<Team> it = teams.iterator();
					while(it.hasNext()) {
						Team team = it.next();
						if(team.name.equals(enter)) {
							team.addMedals(count-1);
							hasTeam = true;
						}
					}
					if( ! hasTeam ) {
						int [] medals = {0,0,0};
						Team team = new Team(enter, medals);
						team.addMedals(count-1);
						teams.add(team);
					}
				}
				count = (count + 1) % 4;
			}
			out.println("Quadro de Medalhas");
			List<Team> list = new ArrayList<Team>(teams);
			Collections.sort(list);
			Iterator<Team> it = list.iterator(); // new TreeSet<Team>(teams).iterator();
			while(it.hasNext()) {
				Team team = it.next();
				out.printf("%s %d %d %d\n"
						,team.name
						,team.medals[0]
						,team.medals[1]
						,team.medals[2]);
			}
		} catch (IOException e) {}
		
	}

}
