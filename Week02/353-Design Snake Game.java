


LinkedList<Position> snake 存构成snake的点
move(String direction) 时，
前一步最新吃进来的就是head，按相应方向移动后，得到新的head的坐标是多少
获得新的head后，判断是否出界
再判断是否是food，
不是则，snake移除head的一个位置
是则，先判断一下当前新head是否走到了snake自身
最后把新head加入到snake中
然后返回snake的长度－1

public class SnakeGame {

// 存的是所有food将要出现的位置的x y坐标
private int[][] food;
private int currFood = 0;
// 存构成snake的点
private LinkedList<Position> snake;
private int width, height;

/** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
public SnakeGame(int width, int height, int[][] food) {
    // if(width <= 0 || height <= 0 || food == null || food.length == 0 || food[0].length == 0) return;
    
    this.food = food;
    
    this.snake = new LinkedList<Position>();
    snake.add(new Position(0, 0));
    
    this.width = width;
    this.height = height;
}

/** Moves the snake.
    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
    @return The game's score after the move. Return -1 if game over. 
    Game over when snake crosses the screen boundary or bites its body. */
public int move(String direction) {
// 	前一步最新吃进来的就是head
    Position head = snake.get(snake.size() - 1);
    Position newHead;
    
//     按相应方向移动后，新的head的坐标是多少
    if(direction.equals("L")) {
        newHead = new Position(head.x, head.y - 1);
        
    } else if(direction.equals("R")) {
        newHead = new Position(head.x, head.y + 1);
        
    } else if(direction.equals("U")) {
        newHead = new Position(head.x - 1, head.y);
        
    } else if(direction.equals("D")) {
        newHead = new Position(head.x + 1, head.y);
        
    } else {
        newHead = new Position(-1, -1);
    }
    
//     获得新的head后，判断是否出界
    // Hit boundary
    if(newHead.x < 0 || newHead.x >= height || newHead.y < 0 || newHead.y >= width) {
        return -1;
    }
    
//     如果food中当前food的坐标等于新的head，那么food首先走到下一步，准备下一个loop的判断
//     如果不等于，snake移除head的一个位置
    // Eat food
    if(currFood < food.length && newHead.x == food[currFood][0] && newHead.y == food[currFood][1]) {
        currFood++;
    } else {
        snake.removeFirst();
    }
    
//     判断一下当前新head是否走到了snake自身
    // Eat body
    for(Position p: snake) { // Could use Map or Set to speed up
        if(p.x == newHead.x && p.y == newHead.y)
            return -1;
    }
    
//     把新head加入到snake中
    // Update Head
    snake.add(newHead);

// 	返回snake的长度－1
    return snake.size() - 1;
}
}

// 有横纵坐标
class Position {
	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}