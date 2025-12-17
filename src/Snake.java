/*
 * Created on 2025-11-21
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import java.util.ArrayList;

public class Snake {
    private SnakeSegment head;
    private Direction direction = Direction.RIGHT; // Set the default direction to RIGHT

    private boolean shouldGrow = false;

    public Snake() {
        // You may change this code for extra credit (implement some fancy stuff!)
        // Feel free to make the starting position random
        Position startingPosition = new Position(10, 10);
        head = new SnakeSegment(startingPosition);
    }

    public void shouldGrow() {
        shouldGrow = true;
    }

    // Removes the last node (tail) of the snake, leaves head untouched
    private void removeTail() {
        if (head == null || head.getNext() == null) {
            // If there's only one segment (head), we can't remove it
            return;
        }
        
        SnakeSegment current = head;
        // Find the second-to-last segment
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        // Remove the last segment
        current.setNext(null);
    }

    // Returns true if the snake is colliding with itself
    public boolean isColliding() {
        // Check if head position matches any body segment (excluding the head itself)
        SnakeSegment current = head.getNext();
        while (current != null) {
            if (head.getPosition().equals(current.getPosition())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Returns true if the specified position is inside the body of the snake
    public boolean isBodyPartAt(Position position) {
        SnakeSegment current = head;
        while (current != null) {
            if (current.getPosition().equals(position)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Sets the direction the snake will move in
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // Gets the length of the snake
    public int getLength() {
        int count = 0;
        SnakeSegment current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // Moves the snake by one in the next direction
    public void move() {
        Position deltaPos = direction.deltaPosition();
        Position newPosition = head.getPosition().add(deltaPos);

        // Handle wrapping around the board edges
        int maxX = SnakeGame.WIDTH / SnakeGame.SQUARE_SIZE;
        int maxY = SnakeGame.HEIGHT / SnakeGame.SQUARE_SIZE;
        
        int wrappedX = newPosition.x;
        int wrappedY = newPosition.y;
        
        if (wrappedX < 0) {
            wrappedX = maxX - 1;
        } else if (wrappedX >= maxX) {
            wrappedX = 0;
        }
        
        if (wrappedY < 0) {
            wrappedY = maxY - 1;
        } else if (wrappedY >= maxY) {
            wrappedY = 0;
        }

        // Create new head segment at the wrapped position
        Position wrappedPosition = new Position(wrappedX, wrappedY);
        SnakeSegment newHead = new SnakeSegment(wrappedPosition);
        newHead.setNext(head);
        head = newHead;

        // Remove tail if not growing, otherwise just reset the flag
        if (!shouldGrow) {
            removeTail();
        } else {
            shouldGrow = false;
        }
    }

    // Return the head of the snake
    public SnakeSegment getHead() {
        return this.head;
    }

    // Returns the start of the snake's body (NOT the head!)
    public SnakeSegment getBody() {
        return head.getNext();
    }

    // OPTIONAL: Implement an algorithm that moves the food for us
    public Direction findNextMove(ArrayList<Food> food) {
        return null;
    }
}

class SnakeSegment {
    private Position position;
    private SnakeSegment next;

    public SnakeSegment(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return this.position;
    }

    public SnakeSegment getNext() {
        return this.next;
    }

    public void setNext(SnakeSegment next) {
        this.next = next;
    }
}
