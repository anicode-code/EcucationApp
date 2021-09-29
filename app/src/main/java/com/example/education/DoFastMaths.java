package com.example.education;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class DoFastMaths extends AppCompatActivity {

    public static final String SHARED_PREFERENCES = "shared_preferences";
    public static final String SCORE_SAVE = "score_save";

    TextView question, correct_wrong_answer, score, timer_text;
    Button option1, option2, option3, option4, nextButton;
    String program_expression;
    int resultOfExpression;

    int saved_score;

    int startTime;
    long timeInMillis;
    CountDownTimer timer;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_fast_maths);
        try {

            nextButton = findViewById(R.id.next_button);
            question = findViewById(R.id.question);
            option1 = findViewById(R.id.option1);
            option2 = findViewById(R.id.option2);
            option3 = findViewById(R.id.option3);
            option4 = findViewById(R.id.option4);
            timer_text = findViewById(R.id.timer);
            score = findViewById(R.id.score);
            correct_wrong_answer = findViewById(R.id.correct_wrong_answer);
            loadScore();
            start();

            option1.setOnClickListener(view -> {
                String correct = "CORRECT ANSWER";
                String wrong = "WRONG ANSWER";
                nextButton.setEnabled(true);
                stopTimer();
                correct_wrong_answer.setVisibility(View.VISIBLE);
                if (Integer.parseInt(option1.getText().toString()) == resultOfExpression) {
                    correct_wrong_answer.setText(correct);
                    correct_wrong_answer.setTextColor(Color.rgb(255, 255, 255));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(0, 255, 0));
                    saved_score = Integer.parseInt(score.getText().toString().replaceAll("Score: ", "")) + currentTime();
                    String update = "Score: " + saved_score;
                    score.setText(update);
                    saveScore();
                    loadScore();
                } else {
                    correct_wrong_answer.setText(wrong);
                    correct_wrong_answer.setTextColor(Color.rgb(0, 0, 0));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(255, 0, 0));
                }
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
            });
            option2.setOnClickListener(view -> {
                String correct = "CORRECT ANSWER";
                String wrong = "WRONG ANSWER";
                nextButton.setEnabled(true);
                stopTimer();
                correct_wrong_answer.setVisibility(View.VISIBLE);
                if (Integer.parseInt(option2.getText().toString()) == resultOfExpression) {
                    correct_wrong_answer.setText(correct);
                    correct_wrong_answer.setTextColor(Color.rgb(255, 255, 255));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(0, 255, 0));
                    saved_score = Integer.parseInt(score.getText().toString().replaceAll("Score: ", "")) + currentTime();
                    String update = "Score: " + saved_score;
                    score.setText(update);
                    saveScore();
                    loadScore();
                } else {
                    correct_wrong_answer.setText(wrong);
                    correct_wrong_answer.setTextColor(Color.rgb(0, 0, 0));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(255, 0, 0));
                }
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
            });
            option3.setOnClickListener(view -> {
                String correct = "CORRECT ANSWER";
                String wrong = "WRONG ANSWER";
                nextButton.setEnabled(true);
                stopTimer();
                correct_wrong_answer.setVisibility(View.VISIBLE);
                if (Integer.parseInt(option3.getText().toString()) == resultOfExpression) {
                    correct_wrong_answer.setText(correct);
                    correct_wrong_answer.setTextColor(Color.rgb(255, 255, 255));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(0, 255, 0));
                    saved_score = Integer.parseInt(score.getText().toString().replaceAll("Score: ", "")) + currentTime();
                    String update = "Score: " + saved_score;
                    score.setText(update);
                    saveScore();
                    loadScore();
                } else {
                    correct_wrong_answer.setText(wrong);
                    correct_wrong_answer.setTextColor(Color.rgb(0, 0, 0));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(255, 0, 0));
                }
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
            });
            option4.setOnClickListener(view -> {
                String correct = "CORRECT ANSWER";
                String wrong = "WRONG ANSWER";
                nextButton.setEnabled(true);
                stopTimer();
                correct_wrong_answer.setVisibility(View.VISIBLE);
                if (Integer.parseInt(option4.getText().toString()) == resultOfExpression) {
                    correct_wrong_answer.setText(correct);
                    correct_wrong_answer.setTextColor(Color.rgb(255, 255, 255));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(0, 255, 0));
                    saved_score = Integer.parseInt(score.getText().toString().replaceAll("Score: ", "")) + currentTime();
                    String update = "Score: " + saved_score;
                    score.setText(update);
                    saveScore();
                    loadScore();
                } else {
                    correct_wrong_answer.setText(wrong);
                    correct_wrong_answer.setTextColor(Color.rgb(0, 0, 0));
                    correct_wrong_answer.setBackgroundColor(Color.rgb(255, 0, 0));
                }
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
            });
            nextButton.setOnClickListener(view -> start());
        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in ocCreate()", Toast.LENGTH_SHORT).show();
        }
    }






















    void start() {
        try {
            program_expression = "";
            resultOfExpression = 0;
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
            correct_wrong_answer.setVisibility(View.GONE);
            timer_text.setVisibility(View.VISIBLE);
            nextButton.setEnabled(false);
            create();
        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in start()", Toast.LENGTH_SHORT).show();
        }
    }














    void startTimer() {
        try {
            timer = new CountDownTimer(timeInMillis, 1000) {
                @Override
                public void onTick(long l) {
                    timeInMillis = l;
                    String timeInSeconds = Integer.toString((int) timeInMillis / 1000);
                    timer_text.setText(timeInSeconds);
                }

                @Override
                public void onFinish() {
                    option1.setEnabled(false);
                    option2.setEnabled(false);
                    option3.setEnabled(false);
                    option4.setEnabled(false);
                    correct_wrong_answer.setVisibility(View.VISIBLE);
                    String timeUp = "TIME UP!";
                    correct_wrong_answer.setText(timeUp);
                    correct_wrong_answer.setTextColor(Color.BLACK);
                    correct_wrong_answer.setBackgroundColor(Color.YELLOW);
                    nextButton.setEnabled(true);
                }
            }.start();

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in startTimer()", Toast.LENGTH_SHORT).show();
        }
    }











    public void setStartTime(int timeInSeconds) {
        try {
            startTime = timeInSeconds;
            timeInMillis = timeInSeconds * 1000L;
            startTimer();

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in setStartTime()", Toast.LENGTH_SHORT).show();
        }
    }













    void stopTimer() {
        try {
            timer.cancel();
            timer_text.setVisibility(View.GONE);

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in stopTimer()", Toast.LENGTH_SHORT).show();
        }
    }















    int currentTime() {
        try {
            return (int) timeInMillis / 1000;

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in currentTime()", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }












    void create() {
        try {
            Random random = new Random();
            int len = 0;
            StringBuilder expression = new StringBuilder();
            while (len <= 1)
                len = random.nextInt(5);
            int[] operands = new int[len];
            for (int i = 0; i < operands.length - 1; i++) {
                expression.append(random.nextInt(100));
                expression.append("-*+".charAt(random.nextInt(3)));
            }
            expression.append(random.nextInt(100));
            program_expression = expression.toString();
            format_expression();
            question.setText(program_expression);
            String infix = infixToPostfix(program_expression);
            resultOfExpression = result(infix);
            String[] options = new String[4];
            Arrays.fill(options, "");
            int answer_position = random.nextInt(4);
            for (int i = 0; i < options.length; i++) {
                if (answer_position != i) {
                    int add_sub = 0;
                    while (add_sub == 0)
                        add_sub = random.nextInt(10);
                    String opt = "";
                    boolean b = random.nextBoolean();
                    while (Arrays.asList(options).contains(opt)) {
                        if (b)
                            opt = Integer.toString(resultOfExpression + add_sub);
                        else
                            opt = Integer.toString(resultOfExpression - add_sub);
                    }
                    options[i] = opt;
                } else
                    options[i] = Integer.toString(resultOfExpression);
            }
            option1.setText(options[0]);
            option2.setText(options[1]);
            option3.setText(options[2]);
            option4.setText(options[3]);
            setStartTime(len * 10);

        } catch (Exception e) {
            nextButton.setEnabled(true);
            Toast.makeText(DoFastMaths.this, "an error occurred, click next", Toast.LENGTH_SHORT).show();
        }
    }











    void format_expression() {
        try {
            program_expression += "  ";
            StringBuilder exp = new StringBuilder();
            for (int i = 0; i < program_expression.length() - 2; i++) {
                exp.append(program_expression.charAt(i));
                if (program_expression.charAt(i) == '(' &&
                        program_expression.charAt(i + 1) == '-' &&
                        Character.isDigit(program_expression.charAt(i + 2)))
                    exp.append(" ").append(program_expression.charAt((i++) + 1)).append(program_expression.charAt((i++) + 1));
                if (!(Character.isDigit(program_expression.charAt(i)) && Character.isDigit(program_expression.charAt(i + 1))))
                    exp.append(" ");
            }
            program_expression = exp.toString().trim();

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in format_expression()", Toast.LENGTH_SHORT).show();
        }
    }












    int getPriority(String ch) {
        try {
            switch (ch) {
                case "+":
                case "-":
                    return 1;
                case "*":
                case "/":
                    return 2;
                case "^":
                    return 3;
            }
            return -1;

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in getPriority()", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }















    boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

















    String infixToPostfix(String exp) {
        try {
            StringBuilder result = new StringBuilder();
            Stack<String> stack = new Stack<>();
            StringTokenizer each_token = new StringTokenizer(exp);
            while (each_token.hasMoreTokens()) {
                String word = each_token.nextToken();
                if (isInteger(word))
                    result.append(word).append(" ");
                else if (word.equals("("))
                    stack.push(word);
                else if (word.equals(")")) {
                    while (!stack.isEmpty() && !stack.peek().equals("("))
                        result.append(stack.pop()).append(" ");
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && getPriority(word) <= getPriority(stack.peek()))
                        result.append(stack.pop()).append(" ");
                    stack.push(word);
                }

            }
            while (!stack.isEmpty()) {
                if (stack.peek().equals("("))
                    return "Invalid Expression";
                result.append(stack.pop()).append(" ");
            }
            return result.toString().trim();

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in infixToPostfix()", Toast.LENGTH_SHORT).show();
            return "";
        }
    }



















    int result(String expression) {
        try {
            Stack<Integer> values = new Stack<>();
            StringTokenizer exp = new StringTokenizer(expression);
            while (exp.hasMoreTokens()) {
                String word = exp.nextToken();
                if (isInteger(word))
                    values.add(Integer.parseInt(word));
                else {
                    int operator2 = values.get(values.size() - 1);
                    values.remove(values.size() - 1);
                    int operator1 = values.get(values.size() - 1);
                    values.remove(values.size() - 1);
                    switch (word) {
                        case "+":
                            values.add(operator1 + operator2);
                            break;
                        case "-":
                            values.add(operator1 - operator2);
                            break;
                        case "*":
                            values.add(operator1 * operator2);
                            break;
                        case "/":
                            values.add(operator1 / operator2);
                            break;
                        case "^":
                            values.add((int) Math.pow(operator1, operator2));
                    }
                }
            }
            return values.get(values.size() - 1);

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in result()", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }










    public void saveScore() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(SCORE_SAVE, Integer.parseInt(score.getText().toString().replaceAll("Score: ", "")));
            editor.apply();

        }catch(Exception e) {
            Toast.makeText(DoFastMaths.this, "an error occurred in saveScore()", Toast.LENGTH_SHORT).show();
        }
    }













    public void loadScore() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
            saved_score = sharedPreferences.getInt(SCORE_SAVE, 0);
            String update = "Score: " + saved_score;
            score.setText(update);

        }catch(Exception e) {
            Toast.makeText(this, "an error occurred in loadScore()", Toast.LENGTH_SHORT).show();
        }
    }
}