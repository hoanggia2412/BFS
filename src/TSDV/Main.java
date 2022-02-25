package TSDV;

import java.io.File;
import java.util.List;
import java.util.Stack;

public class Main {
	static Stack<List> stack = new Stack<>();

	public static void main(String[] args) {
		File maze2 = new File("src/tsdv/map2.txt");
		try {
			execute(maze2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void execute(File file) throws Exception {
		Maze maze = new Maze(file);
		BFSMazeSolver bfs = new BFSMazeSolver();
		for (Coordinate coordinate : maze.getEnds()) {
			maze.setEnd(coordinate);
			int step = 0;
			List<Coordinate> path = bfs.solve(maze);
			step = path.size();
			if (step != 0) {

				if (stack.empty() || stack.peek().size() >= step) {
					stack.push(path);
				}
			}
			maze.reset();
		}
		maze.printPath(stack.peek());
		System.out.println(stack.peek().size());
	}
}
