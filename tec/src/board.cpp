#include <sstream>
#include "board.h"

using namespace Constants;

Board::Board() : cells_{{ false }}, currentScore_(0) {
    displayScore(0);
}

void Board::draw(SDL_Renderer * renderer /* TTF_Font *font */) {
    // displayScore(renderer, font);
    SDL_SetRenderDrawColor(
        renderer,
        /* 밝은 회색: */ 140, 140, 140, 255);
    for (int column = 0; column < BoardColumns; ++column) {
        for (int row = 0; row < BoardRows; ++row) {
            if (cells_[column][row]) {
                SDL_Rect rect{
                    column * Offset + 1,
                    row * Offset + 1,
                    Offset - 2,
                    Offset - 2
                };
                SDL_RenderFillRect(renderer, &rect);
            }
        }
    }
}

bool Board::isCollision(const Piece &piece) const {
    for (int column = 0; column < PieceSize; ++column) {
        for (int row = 0; row < PieceSize; ++row){
            if (piece.isBlock(column, row)) {
                int columnTarget = piece.getColumn() + column;
                int rowTarget = piece.getRow() + row;
                if (
                    columnTarget < 0
                    || columnTarget >= BoardColumns
                    || rowTarget < 0
                    || rowTarget >= BoardRows
                ) {
                    return true;
                }
                if (cells_[columnTarget][rowTarget]) return true;
            }
        }
    }
    return false;
}

void Board::unite(const Piece &piece) {
    for (int column = 0; column < PieceSize; ++column) {
        for (int row = 0; row < PieceSize; ++row) {
            if (piece.isBlock(column, row)) {
                int columnTarget = piece.getColumn() + column;
                int rowTarget = piece.getRow() + row;
                cells_[columnTarget][rowTarget] = true;
            }
        }
    }


    while (areFullRowsPresent()) {
        for (int row = BoardRows - 1; row >= 0; --row) {
            if (isRowFull(row)) {
                updateOffsetRow(row);
                currentScore_ += 1;
                for (int column = 0; column < BoardColumns; ++column) {
                    cells_[column][0] = false;
                }
            }
        }
        displayScore(currentScore_);
    }
}

bool Board::isRowFull(int row) {
    for (int column = 0; column < BoardColumns; ++column) {
        if(!cells_[column][row]) return false;
    }
    return true;
}

bool Board::areFullRowsPresent() {
    for (int row = BoardRows - 1; row >= 0; --row) {
        if (isRowFull(row)) return true;
    }
    return false;
}

void Board::updateOffsetRow(int fullRow) {
    for (int column = 0; column < BoardColumns; ++column) {
        for (int rowOffset = fullRow - 1; rowOffset >= 0; --rowOffset) {
            cells_[column][rowOffset + 1] =
                cells_[column][rowOffset];
        }
    }
}

void Board::displayScore(int newScore) {
    std::stringstream action;
    action << "document.getElementById('score').innerHTML =" << newScore;
    emscripten_run_script(action.str().c_str());
}