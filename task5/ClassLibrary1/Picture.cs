using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Task5
{
    public class Picture
    {
        private Image[] images;
        public Image Sprite { get; protected set; }
        public int X { get; set; }
        public int Y { get; set; }
        private int index = 0;

        public Picture(Image[] images)
        {
            this.images = images;
            Sprite = images[0];
        }

        public void Update()
        {
           index++;
           if(index > images.Length-1)
            {
                index = 0;
            }
            Sprite = images[index];

        }
    }   
}
