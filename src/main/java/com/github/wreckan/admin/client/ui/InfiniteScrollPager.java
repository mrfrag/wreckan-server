package com.github.wreckan.admin.client.ui;

import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasRows;

public class InfiniteScrollPager extends AbstractPager {

	private static final int DEFAULT_INCREMENT = 20;

	private int incrementSize = DEFAULT_INCREMENT;

	private int lastScrollPos = 0;

	private final ScrollPanel scrollable = new ScrollPanel();

	public InfiniteScrollPager() {
		initWidget(scrollable);

		scrollable.getElement().setTabIndex(-1);
		scrollable.addScrollHandler(new ScrollHandler() {
			public void onScroll(ScrollEvent event) {
				int oldScrollPos = lastScrollPos;
				lastScrollPos = scrollable.getVerticalScrollPosition();
				if (oldScrollPos >= lastScrollPos) {
					return;
				}

				HasRows display = getDisplay();
				if (display == null) {
					return;
				}
				int maxScrollTop = scrollable.getWidget().getOffsetHeight() - scrollable.getOffsetHeight();
				if (lastScrollPos >= maxScrollTop) {
					int newPageSize = Math.min(display.getVisibleRange().getLength() + getIncrementSize(), display.getRowCount());
					display.setVisibleRange(0, newPageSize);
				}
			}
		});
	}

	@Override
	protected void onRangeOrRowCountChanged() {

	}

	@Override
	public void setDisplay(HasRows display) {
		assert display instanceof Widget : "display must extend Widget";
		scrollable.setWidget((Widget) display);
		super.setDisplay(display);
	}

	public int getIncrementSize() {
		return incrementSize;
	}

	public void setIncrementSize(int incrementSize) {
		this.incrementSize = incrementSize;
	}

}
