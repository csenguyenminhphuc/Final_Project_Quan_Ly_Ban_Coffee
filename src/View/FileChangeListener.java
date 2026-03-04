package View;

/**
 * Interface để lắng nghe sự thay đổi file giữa các view
 */
public interface FileChangeListener {
	/**
	 * Được gọi khi file được lưu hoặc thay đổi
	 * @param filePath Đường dẫn file mới
	 */
	void onFileChanged(String filePath);
	
	/**
	 * Được gọi khi file bị xóa hoặc clear
	 */
	void onFileCleared();
}
