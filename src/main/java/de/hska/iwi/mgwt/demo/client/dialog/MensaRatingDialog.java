package de.hska.iwi.mgwt.demo.client.dialog;

import org.cobogw.gwt.user.client.ui.Rating;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.dialog.PopinDialog;
import com.googlecode.mgwt.ui.client.widget.Button;

/**
 * Dialog for rating a meal. Contains custom stars.
 * NOTE: It does not send any data to anywhere. Just showcase purposes at the moment!
 * 
 * @author Martin
 *
 */
public class MensaRatingDialog extends PopinDialog {

	/**
	 * Public constructor.
	 */
	public MensaRatingDialog() {
		VerticalPanel wrapper = new VerticalPanel();
		wrapper.getElement().addClassName("rating-dialog-wrapper");
		
		Label titleLabel = new Label();
		titleLabel.setText("Bewerte die Speise!");
		titleLabel.getElement().getStyle().setColor("#DB0134");
		titleLabel.getElement().getStyle().setProperty("textAlign", "center");
		titleLabel.getElement().getStyle().setFontSize(1.5, Unit.EM);
		titleLabel.getElement().getStyle().setMarginBottom(25, Unit.PX);
		wrapper.add(titleLabel);
		
		// TODO: find some nasty vector graphics instead of pixel graphics.
		Rating rating = new Rating(0, 5, Rating.LTR, "assets/icons/rating_full.png", "assets/icons/rating_empty.png", 
										"assets/icons/rating_hover.png", 52, 50);

		rating.getElement().getStyle().setProperty("textAlign", "-webkit-center");
		rating.getElement().getStyle().setMarginBottom(25, Unit.PX);
		rating.setHeight("50px");
		wrapper.add(rating);

		Button submitRating = new Button();
		submitRating.setText("Abschicken");
		submitRating.getElement().getStyle().setProperty("horizontalAlign", "center");
		
		submitRating.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				hide();
			}
		});
		
		wrapper.add(submitRating);
		
		this.add(wrapper);
		
		this.setCenterContent(true);
	}
	 
}