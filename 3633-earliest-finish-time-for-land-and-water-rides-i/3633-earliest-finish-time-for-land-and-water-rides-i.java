class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int result = Integer.MAX_VALUE;

        int landLength = landStartTime.length;
        int waterLength = waterStartTime.length;

        for (int landIndex = 0; landIndex < landLength; landIndex++) {

            int landFinish =
                landStartTime[landIndex] + landDuration[landIndex];

            for (int waterIndex = 0; waterIndex < waterLength; waterIndex++) {

                int waterBegin =
                    Math.max(landFinish, waterStartTime[waterIndex]);

                int finishTime =
                    waterBegin + waterDuration[waterIndex];

                result = Math.min(result, finishTime);
            }
        }

        for (int waterIndex = 0; waterIndex < waterLength; waterIndex++) {

            int waterFinish =
                waterStartTime[waterIndex] + waterDuration[waterIndex];

            for (int landIndex = 0; landIndex < landLength; landIndex++) {

                int landBegin =
                    Math.max(waterFinish, landStartTime[landIndex]);

                int finishTime =
                    landBegin + landDuration[landIndex];

                result = Math.min(result, finishTime);
            }
        }

        return result;
    }
}