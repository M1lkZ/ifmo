#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>

struct __attribute__((packed)) bmp_header {
        uint16_t bfType;
        uint32_t  bfileSize;
        uint32_t bfReserved;
        uint32_t bOffBits;
        uint32_t biSize;
        uint32_t biWidth;
        uint32_t  biHeight;
        uint16_t  biPlanes;
        uint16_t biBitCount;
        uint32_t biCompression;
        uint32_t biSizeImage;
        uint32_t biXPelsPerMeter;
        uint32_t biYPelsPerMeter;
        uint32_t biClrUsed;
        uint32_t  biClrImportant;
};

struct pixel { uint8_t b, g, r; };

struct image {
    uint64_t width, height;
    struct pixel* data;
};

struct image generate_pic(uint32_t height, uint32_t width){
    struct image img;
    struct pixel* data = malloc((width*height) * sizeof(struct pixel));
    img.width = width;
    img.height = height;
    img.data = data;
    return img;
}

struct bmp_header read_header(FILE *src){
    struct bmp_header header;
    fread(&header, sizeof(struct bmp_header), 1, src);
    return header;
}

int64_t get_padding(uint32_t width){
    return (width % 4 == 0) ? 0 : 4 - (int64_t)((width * sizeof(struct pixel)) % 4);
}

struct bmp_header generate_header(struct image img){
    return (struct bmp_header) {
            .bfType = 0x4d42,
            .bfileSize = img.width * img.height * sizeof(struct pixel) + get_padding(img.width) * img.height + sizeof(struct bmp_header),
            .bfReserved = 0,
            .bOffBits = sizeof(struct bmp_header),
            .biSize = 40,
            .biWidth = img.width,
            .biHeight = img.height,
            .biPlanes = 1,
            .biBitCount = 24,
            .biCompression = 0,
            .biSizeImage = (img.width + get_padding(img.width)) * img.height,
            .biXPelsPerMeter = 0,
            .biYPelsPerMeter = 0,
            .biClrUsed = 0,
            .biClrImportant = 0,
    };

}

void read_pixels(FILE *src, struct image img, struct bmp_header header){
    size_t c = 0;
    for (int i = 0; i < header.biHeight; i++){
        for (int j = 0; j < header.biWidth; j++) {
            fread(img.data + c, sizeof(struct pixel), 1, src);
            c++;
        }
        fseek(src, get_padding(header.biWidth),SEEK_CUR);
    }
}


void write_img(FILE *dest, struct image img, struct bmp_header header){
    size_t c = 0;
    fwrite(&header, sizeof(struct bmp_header), 1, dest);
    fseek(dest, header.bOffBits, SEEK_SET);
    uint8_t trash = 0;
    for (int i = 0; i < img.height; i++){
        for (int j = 0; j < img.width; j++) {
            fwrite(img.data + c, sizeof(struct pixel), 1, dest);
            c++;
        }
        for (int k = 0; k < get_padding(img.width); k++) {
            fwrite(&trash, 1, 1, dest);
        }
    }

}

void transform(struct image orig, struct image rot){
    size_t c = 0;
    for (int i = 0; i < orig.width; i++) {
        for (int j = 0; j < orig.height; j++) {
            size_t ind = i + (orig.width * (orig.height - j - 1));
            rot.data[c] = orig.data[ind];
            c++;
        }
    }
}

int main( int argc, char** argv ) {
    (void) argc; (void) argv;
    char* file = "/home/nick/Project/C/Programming-languages/assignment-3-image-rotation/solution/include/big.bmp";
    char* rotated = "/home/nick/Project/C/Programming-languages/assignment-3-image-rotation/solution/include/rotated.bmp";

    FILE *src = fopen(file,"rb");
    struct bmp_header header = read_header(src);
    struct image orig = generate_pic(header.biHeight, header.biWidth);
    struct image rot = generate_pic(header.biWidth, header.biHeight);
    read_pixels(src, orig, header);
    fclose(src);

    transform(orig, rot);

    FILE *dest = fopen(rotated, "wb");
    write_img(dest, rot, generate_header(rot));
    fclose(dest);
    return 0;
}
