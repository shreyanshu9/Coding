import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PackageDelivery {
	static HashMap<Integer, Double> weightMap = new HashMap<Integer, Double>();
	static HashMap<Integer, Double> costMap = new HashMap<Integer, Double>();
	static double packageWeight;
    static String itemList = "-";
    static double costList = 0;
    static double weightList = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String path = reader.readLine();
		reader = new BufferedReader(new FileReader(path));
		String line = reader.readLine();
		while (line != null) {
			getContent(line);
			getItemList();
			System.out.println(itemList);
			line = reader.readLine();
			weightMap.clear();
			costMap.clear();
			itemList = "-";
			costList = 0;
			weightList = 0;
		}
		reader.close();
	}

	private static void getItemList() {
		double cost = 0, takeCost, leaveCost;
		String content = "-";
		takeCost = take(1,cost,content, packageWeight);
		leaveCost = leave(1,cost,content, packageWeight);
		cost = Math.max(takeCost, leaveCost);
	}

	private static double leave(int i, double cost, String content, double weight) {
		double takeCost, leaveCost;
		if (weightMap.get(i) != null) {
			 takeCost = take(i+1, cost, content, weight);
			 leaveCost = leave(i+1, cost, content, weight);
			 cost = Math.max(takeCost, leaveCost);
		}
		return cost;
	}

	private static double take(int i, double cost, String content, double weight) {
		double takeCost, leaveCost, tempCost;
		if (weightMap.get(i) != null) {
			 weight = weight - weightMap.get(i);
			 if (weight < 0) {
				 return cost;
			 }
			 cost = cost + costMap.get(i);
			 tempCost = cost;
			 if (content.equals("-")) {
				 content = "" + i;
			 } else {
				 content = content + "," + i;
			 }
			 takeCost = take(i+1, cost, content, weight);
			 leaveCost = leave(i+1, cost, content, weight);
			 cost = Math.max(takeCost, leaveCost);
			 if (cost > costList) {
				 costList = cost;
				 itemList = content;
				 weightList = weight;
			 }  else if (cost == costList && tempCost == costList && weight > weightList) {
				 costList = cost;
				 itemList = content;
				 weightList = weight;
			 }
		}
		return cost;
	}

	private static void getContent(String line) {
		int colonIndex, index;
		double weight, cost;
		StringTokenizer st;
		String temp;
		String splitContent[] = null;
		colonIndex = line.indexOf(":");
		temp = line.substring(0, colonIndex - 1);
		packageWeight = Double.parseDouble(temp);
		temp = line.substring(colonIndex + 2);
		st = new StringTokenizer(temp);
		while (st.hasMoreElements()) {
			temp = st.nextToken().replace("(", "");
			temp = temp.replace(")", "");
			splitContent = temp.split(",");
			splitContent[2] = splitContent[2].substring(1);
			index = Integer.parseInt(splitContent[0]);
			weight = Double.parseDouble(splitContent[1]);
			cost =  Double.parseDouble(splitContent[2]);
				weightMap.put(index, weight);
				costMap.put(index, cost);
		}
	}
}