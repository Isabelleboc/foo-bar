public static int solution(int[][] mat)
	{
		int w= mat.length;
		int h= mat[0].length;
		int shortest=BFS(mat, 0, 0, w-1, h-1, w,h);
    
		for(int i=0 ; i< w; i++)   //iterate and find shortest path for each wall removed
		{
			for(int j=0; j<h;j++)
			{
				if(mat[i][j]==1)
				{
					mat[i][j]=0;  //remove wall
					int temp=BFS(mat, 0, 0, w-1, h-1, w,h);
					if(temp<shortest && temp!=-1) //if new shortest path found and path exists
					{
						shortest=temp;
					}
					mat[i][j]=1;    //put wall back
				}
			}
		}
		
		return shortest;
	}

	//north, south, east & west directions in arrays
	private static final int row[] = { -1, 0, 0, 1 };
	private static final int col[] = { 0, -1, 1, 0 };

	// is not a valid position or has value 1 or it is already visited
	private static boolean isValid(int mat[][], boolean visited[][], int row, int col, int M, int N)
	{
		return (row >= 0) && (row < M) && (col >= 0) && (col < N)
					   && mat[row][col] == 0 && !visited[row][col];
	}

	// Find Shortest Possible Route in a matrix mat from source
	// cell (i, j) to destination cell (x, y)
	private static int BFS(int mat[][], int i, int j, int x, int y, int M, int N)
	{
		//to keep track of visited cells
		boolean[][] visited = new boolean[M][N];

		// create an empty queue
		Queue<Node> q = new ArrayDeque<>();

		// mark starting position as visited
		visited[i][j] = true;
		q.add(new Node(i, j, 0));

		int min_dist = Integer.MAX_VALUE;


		while (!q.isEmpty())
		{
			Node node = q.poll();
			
			i = node.x;
			j = node.y;
			int dist = node.dist; //minimum distance from starting position

			// if reached (w-1,h-1)
			if (i == x && j == y)
			{
				min_dist = dist;
				break;
			}

			// check for all 4 possible movements from current position
			// and enqueue each valid movement
			for (int k = 0; k < 4; k++)
			{
				// check if it is possible to go to position
				// (i + row[k], j + col[k]) from current position
				if (isValid(mat, visited, i + row[k], j + col[k], M,N))
				{
					// mark next position as visited and enqueue it
					visited[i + row[k]][j + col[k]] = true;
					q.add(new Node(i + row[k], j + col[k], dist + 1));
				}
			}
		}

		if (min_dist != Integer.MAX_VALUE) 
			return (min_dist+1);
		else {
			return -1;
		}
	}
}
