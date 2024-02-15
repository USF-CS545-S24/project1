package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

public class RandomizedQuickSort implements SortingAlgorithm {

    // FILL IN CODE: Add helper methods partition and computePivot to this class.
    // In computePivot, the pivot value should be computed as the median of values at three random indices of the subarray from low to high

    /**
     * Sort the given subarray of songs from low to high using randomized quick sort (recursive), where the pivot
     * is picked as the median of values at three random indices from low to high.
     * @param songs array of songs
     * @param low index of the first element of the subarray we need to sort
     * @param high index of the last element of the subarray we need to sort
     * @param isAscending if true, sort in increasing order, otherwise in decreasing order
     * @param sb StringBuilder that should store the string showing the array after each partition of randomized quick sort.
     *           Show only the first letter of the title of each song in the songs array,
     *           and "highlight" the pivot element that was used for the partition
     *           by showing it in lower case.
     *
     */
    @Override
    public void sort(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb) {
        // FILL IN CODE

    }

}
