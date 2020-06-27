package ndj.no.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Paging {
    private int itemPerPage;
    private int currentPage;
    private String orderBy;
    private String sortType;

    public static final String DESC = "DESC";
    public static final String ASC = "ASC";

    public Paging() {
        this.itemPerPage = 20;
        this.currentPage = 1;
        this.orderBy = "id";
        this.sortType = ASC;
    }

    public int getStartPosition() {
        return (currentPage - 1) * itemPerPage;
    }
}
